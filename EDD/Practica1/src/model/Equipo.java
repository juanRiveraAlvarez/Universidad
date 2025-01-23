package model;



public class Equipo{
  
  private String nombre;
  private long id;
  private Fecha fecha;
  private long valor;
  private Usuario empleado;

  public Equipo(){

  }
  
  public Equipo(String nombre, long id, Fecha fecha, long valor){
    this.id = id;
    this.fecha = fecha;
    this.valor = valor;
    this.nombre = nombre;
  }

  public void setId(long id){
    this.id = id;
  }

  public void setFecha(Fecha fecha){
    this.fecha = fecha;
  }

  public void setValor(long valor){
    this.valor = valor;
  }

  public void setEmpleado(Usuario empleado){
    this.empleado = empleado;
  }
 
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public long getId(){
    return this.id;
  }

  public Fecha getFecha(){
    return this.fecha;
  }

  public long getValor(){
    return this.valor;
  }

  public Usuario getEmpleado(){
    return this.empleado;
  }
  
  public String getNombre(){
    return this.nombre;
  }

}
