package model.dto;

import model.Usuario;

public class LoginDto{
  
  private long id;
  private String password;
  private String rol;

  public LoginDto(){
    
  }
  
  public LoginDto(long id, String password, String rol){
    this.id = id;
    this.password = password;
    this.rol = rol;
  }

  public void setId(long id){
    this.id = id;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public void setRol(String rol){
    this.rol = rol;
  }

  public long getId(){
    return this.id;
  }

  public String getPassword(){
    return this.password;
  }

  public String getRol(){
    return this.rol;
  }

}
