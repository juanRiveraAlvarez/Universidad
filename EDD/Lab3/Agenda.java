import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Agenda{
  
  private Usuario registro[];
  private int no_reg;

  public Agenda(int capacity){
    this.registro = new Usuario[capacity];
    this.no_reg = 0;
  }
  
  public int getNo_reg(){
    return this.no_reg;
  }
  
  public Usuario[] getRegistro(){
    return this.registro;
  }

  public boolean agregar(Usuario u){
    if(this.buscar(u.getId()) != -1){
      return false;
    }
    for(int i = 0; i<this.registro.length; i++){
      if(this.registro[i] == null){
        this.registro[i] = u;
        return true;
      }
    }
    return false;
  }

  public int buscar(Long id){
    for(int i = 0; i<this.registro.length; i++){
      if(this.registro[i] != null && this.registro[i].getId() == id){
        return i;
      }
    }
    return -1;
  }
  
  public boolean eliminar(long id){
    if(this.buscar(id) != -1){
      for(int i = this.buscar(id); i<this.registro.length-1; i++){
        this.registro[i] =this.registro[i+1];
      }
      this.registro[this.registro.length-1] = null;
      return true;
    }
    return false;
  }
  
  public void toFile(String fileName){
    try{
      File file = new File(fileName);
      FileWriter salida = new FileWriter(file, true);
      for(Usuario i: this.registro){
        if(i != null){
          salida.write(i.getNombre()+" "+i.getId()); 
          salida.write("\r\n");
        }
      }
      salida.close();
    }catch(Exception e){
      System.out.println("Error -> "+e);
    }
  }

  public void importUsers(){
    try{
      File file = new File("agenda.txt");
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()){
        String[] usuario = sc.nextLine().split(" ");
        this.agregar(new Usuario(usuario[0], Integer.parseInt(usuario[1])));
      }
    }catch(FileNotFoundException e){
      System.out.println("Error -> "+e);
    }
  }

  public static void main(String[] args){
    Agenda agenda = new Agenda(5);
    agenda.agregar(new Usuario("juan1",1));
    agenda.agregar(new Usuario("juan2",2));
    agenda.agregar(new Usuario("juan3",3));
    agenda.agregar(new Usuario("juan4",4));
    agenda.agregar(new Usuario("juan5",5));
    System.out.println("Buscando usuario id 5 ...");
    System.out.println("Se encuentra en la posicion "+ agenda.buscar((long)3));
    agenda.toFile("agenda.txt");
  }

}
