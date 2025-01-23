package model.dto;

import model.Usuario;

abstract class SolicitudDto{
  
  private String nombre;
  private long id;
  private String estado;

  public SolicitudDto(){
    
  }
  
  public SolicitudDto(String nombre, long id, String estado){
    this.nombre = nombre;
    this.id =  id;
    this.estado = estado; 
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  
  public String getNombre(){
    return this.nombre;
  }

  public void setId(long id){
    this.id = id;
  }

  public long getId(){
    return this.id;
  }

  public void setEstado(String estado){
    this.estado = estado;
  }

  public String getEstado(){
    return this.estado;
  }

}
