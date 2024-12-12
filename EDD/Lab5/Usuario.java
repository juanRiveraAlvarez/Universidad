public class Usuario{
  
  private String nombre;
  private long id;
  private Fecha fecha_nacimiento;
  private String ciudad_nacimiento;
  private long tel;
  private String email;
  private Direccion dir;

  public Usuario(){

  }

  public Usuario(String nombre, long id){
    this.nombre = nombre;
    this.id = id;
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

  public void setCiudad_nacimiento(String ciudad_nacimiento){
    this.ciudad_nacimiento = ciudad_nacimiento;
  }

  public void setTel(long tel){
    this.tel = tel;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public void setDir(Direccion dir){
    this.dir = dir;
  }

  @Override
  public String toString(){
    return "Nombre: "+this.nombre+
            ", Telefono: "+this.tel+
            ", Email: "+this.email;
  }

}
