package model.dto;

import model.Equipo;
import model.Usuario;

public class SolicitudCargarEquipoDto extends SolicitudDto{

  private Equipo equipo;

  public SolicitudCargarEquipoDto(){

  }
  
  public SolicitudCargarEquipoDto(String nombre, long id, Equipo equipo){
    super(nombre, id, "pendiente");
    this.equipo = equipo;
  }


  public void setEquipo(Equipo equipo){
    this.equipo = equipo;
  }

  public Equipo getEquipo(){
    return this.equipo;
  }

  @Override
  public String toString(){
    return this.getNombre()+" "+this.getId()+" "+this.getEquipo().getNombre()+" "+this.getEquipo().getId()+" "+this.getEquipo().getValor();
  }

}
