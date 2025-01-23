package model.dto;

public class NotificacionDto{

  private long idUsuario;
  private long idEquipo;
  private String estado;

  public NotificacionDto(){

  }
  
  public NotificacionDto(long idUsuario, long idEquipo, String estado){
    this.idUsuario = idUsuario;
    this.idEquipo = idEquipo;
    this.estado = estado;
  }

  public void setIdUsuario(long idUsuario){
    this.idUsuario = idUsuario;
  }

  public void setIdEquipo(long idEquipo){
    this.idEquipo = idEquipo;
  }

  public void setEstado(String estado){
    this.estado = estado;
  }

  public long getIdUsuario(){
    return this.idUsuario;
  }

  public long getIdEquipo(){
    return this.idEquipo;
  }
  
  public String getEstado(){
    return this.estado;
  }

  @Override
  public String toString(){
    return this.idUsuario+" "+this.idEquipo+" "+this.estado;
  }

}
