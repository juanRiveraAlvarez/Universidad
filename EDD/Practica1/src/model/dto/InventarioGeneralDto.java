package model.dto;

import model.Equipo;

public class InventarioGeneralDto{

  private String nombre;
  private long idUsuario;
  private Equipo equipo;

  public InventarioGeneralDto(){

  }
  
  public InventarioGeneralDto(String nombre, long id, Equipo equipo){
    this.nombre = nombre;
    this.idUsuario = id;
    this.equipo = equipo;
  }
  
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public void setIdUsuario(long id){
    this.idUsuario = id;
  }
 
  public void setEquipo(Equipo equipo){
    this.equipo = equipo;
  }

  public String getNombre(){
    return this.nombre;
  }

  public long getIdUsuario(){
    return this.idUsuario;
  }

  public Equipo getEquipo(){
    return this.equipo;
  }

}
