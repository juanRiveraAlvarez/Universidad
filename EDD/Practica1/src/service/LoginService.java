package service;

import model.dto.*;
import repository.*;
import repository.factory.*;

public class LoginService{

  private PersistenceInterface loginRepository;
  private PersistenceInterface empleadoRepository;

  public LoginService(){
    this.loginRepository = RepositoryFactory.createRepository("Login");
    this.empleadoRepository = RepositoryFactory.createRepository("Empleado");
  }

  public String login(long id, String password){
    LoginDto ld =  (LoginDto) this.loginRepository.loadById(id);
    if(((LoginDto)this.loginRepository.loadById(id)).getPassword().equals(password)){    
      return ld.getRol();
    }else{
      return ""; 
    }
  }

  public boolean changePassword(long id, String newPassword){
    try{
      if(((LoginDto)this.loginRepository.loadById(id)).getId() == id){
        String rol = ((LoginDto)this.loginRepository.loadById(id)).getRol();
        this.loginRepository.deleteById(id); 
        this.loginRepository.save(new LoginDto(id,newPassword,rol));
        return true; 
      }else{
        return false;
      }
    }catch(Exception e){
      System.out.println(e);
    }finally{
      return false;
    }
  }
  
}
