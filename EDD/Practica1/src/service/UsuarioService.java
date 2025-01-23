package service;

import repository.factory.RepositoryFactory;
import repository.PersistenceInterface;

public class UsuarioService{

  private PersistenceInterface empleadoRepository;
  private PersistenceInterface loginRepository;

  public UsuarioService(){
    this.empleadoRepository = RepositoryFactory.createRepository("Empleado");
    this.loginRepository = RepositoryFactory.createRepository("Login");
  }

  public void eliminarUsuario(long id){
    this.empleadoRepository.deleteById(id);
    this.loginRepository.deleteById(id);
  }

}
