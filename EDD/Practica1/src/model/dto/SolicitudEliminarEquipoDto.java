package model.dto;

import model.Usuario;


public class SolicitudEliminarEquipoDto extends SolicitudDto{
  
  private long codigoEquipo;
  private String descripcion;

  public SolicitudEliminarEquipoDto(){

  }
  
  public SolicitudEliminarEquipoDto(String nombre, long id, long codigoEquipo, String descripcion ){
    super(nombre, id, "pendiente");
    this.codigoEquipo = codigoEquipo;
    this.descripcion = descripcion;
  }

  public void setCodigoEquipo(long codigoEquipo){
    this.codigoEquipo = codigoEquipo;
  }

  public long getCodigoEquipo(){
    return this.codigoEquipo;
  }

  public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
  }

  public String getDescripcion(){
    return this.descripcion;
  }

  @Override 
  public String toString(){
    return this.getNombre()+" "+this.getId()+" "+this.codigoEquipo+" "+this.descripcion;
  }

}
