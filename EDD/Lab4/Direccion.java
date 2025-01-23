public class Direccion{
  
  private String calle;
  private String nomenclatura;
  private String barrio;
  private String ciudad;
  private String edificio;
  private String apto;

  public Direccion(){

  }

  public void setCalle(String calle){
    this.calle = calle;
  }

  public void setNomenclatura(String nomenclatura){
    this.nomenclatura = nomenclatura;
  }

  public void setBarrio(String barrio){
    this.barrio = barrio;
  }

  public void setCiudad(String ciudad){
    this.ciudad = ciudad;
  }

  public void setEdificio(String edificio){
    this.edificio = edificio;
  }
  
  public void setApto(String apto){
    this.apto = apto;
  }

  public String getCalle(){
    return this.calle;
  }

  public String getNomenclatura(){
    return this.nomenclatura;
  }

  public String getBarrio(){
    return this.barrio;
  }

  public String getCiudad(){
    return this.ciudad;
  }

  public String getEdificio(){
    return this.edificio;
  }
  
  public String getApto(){
    return this.apto;
  }

  @Override
  public String toString(){
    return "Calle "+this.calle+this.nomenclatura+", Barrio: "+this.barrio+", Ciudad: "+this.ciudad+", Edificio: "+this.edificio+", Apto: "+this.apto;
  }
}
