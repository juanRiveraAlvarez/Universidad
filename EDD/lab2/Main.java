import java.util.Scanner;

public class Main{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    Fecha fecha1 = new Fecha((short)4,(short)12,(short)2003);
    System.out.println("Fecha: "+fecha1.getDia()+" - "+fecha1.getMes()+" - "+fecha1.getA());
    Direccion direccion1 = new Direccion();
    direccion1.setCalle("92");
    direccion1.setNomenclatura("c");
    direccion1.setBarrio("Francisco Antonio Zea");
    direccion1.setCiudad("Medellin");
    System.out.println("Direccion: "+direccion1.toString());

    try{
      
      System.out.print("Ingresar nombre -> ");
      String nombre = sc.nextLine();
      System.out.print("Ingresar telefono -> ");
      long telefono = sc.nextLong();
      System.out.print("Ingresar email -> ");
      String email = sc.next();
    
      Usuario empleado = new Usuario(nombre,1);
      empleado.setTel(telefono);
      empleado.setEmail(email);
      System.out.println(empleado.toString());

    }catch(Exception e){
      System.out.println("Error -> "+ e);
    }




  }
}
