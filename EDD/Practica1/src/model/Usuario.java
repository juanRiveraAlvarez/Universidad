package model;

public class Usuario{
  
  private String nombre;
  private long id;
  private Fecha fecha_nacimiento;
  private String ciudad_nacimiento;
  private long tel;
  private String email;
  private Direccion dir;
  private ListaDoble equipos;
  private String rol;

  public Usuario(){

  }
  
  public Usuario(String nombre, long id, String email){
    this.nombre = nombre;
    this.id = id;
    this.email = email;
  }

  public Usuario(String nombre, long id, Fecha fecha_nacimiento, String ciudad_nacimiento, long tel, String email, Direccion dir){
    this.nombre = nombre;
    this.id = id;
    this.fecha_nacimiento = fecha_nacimiento;
    this.ciudad_nacimiento = ciudad_nacimiento;
    this.tel = tel;
    this.email = email;
    this.dir = dir;
  }

  public void setRol(String rol){
    this.rol = rol;
  }

  public String getRol(){
    return this.rol;
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

  public Long getId(){
    return this.id;
  }

  public void setFecha_nacimiento(Fecha fecha_nacimiento){
    this.fecha_nacimiento = fecha_nacimiento;
  }
 
  public Fecha getFecha(){
    return this.fecha_nacimiento;
  }

  public void setCiudad_nacimiento(String ciudad_nacimiento){
    this.ciudad_nacimiento = ciudad_nacimiento;
  }
  
  public String getCiudad_nacimiento(){
    return this.ciudad_nacimiento;
  }

  public void setTel(long tel){
    this.tel = tel;
  }
  
  public long getTel(){
    return this.tel;
  }

  public void setEmail(String email){
    this.email = email;
  }
  
  public String getEmail(){
    return this.email;
  }


  public void setDir(Direccion dir){
    this.dir = dir;
  }
  
  public Direccion getDireccion(){
    return this.dir;
  }

  @Override
  public String toString(){
    return "Nombre: "+this.nombre+
            ", Telefono: "+this.tel+
            ", Email: "+this.email+
            ", Fecha: "+this.fecha_nacimiento;
  }

}
