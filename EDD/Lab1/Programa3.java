import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

class Programa3{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    Map<String, String> datos = new HashMap<>(); 

    datos.put("Juan1223","J12an*.");
    datos.put("Maria2345","M23a*.");
    datos.put("Pablo1459","P14o*.");
    datos.put("Ana3456","A34a*.");

    int intentos = 0;
    String usuario, password;

    while(intentos<3){
      System.out.print("Inserte su nombre de usuario -> ");
      usuario = sc.nextLine();
      System.out.print("Inserte su contrasena -> ");
      password = sc.nextLine();
      if(datos.get(usuario).equals(password)){
        System.out.println("Acceso permitido");
        break;
      }else{
        System.out.println("Datos incorrectos");
      }
      intentos++;
    }
    
    if(intentos == 3){
      System.out.println("Lo siento, su acceso no es permitido"); 
    }

  }
}
