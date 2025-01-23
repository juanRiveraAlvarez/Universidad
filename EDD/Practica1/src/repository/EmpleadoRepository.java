package repository;

import model.Usuario;
import model.ListaDoble;
import model.Fecha;
import model.Direccion;
import model.NodoDoble;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class EmpleadoRepository implements PersistenceInterface<Usuario>{

  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;
  private ListaDoble empleados;
  private String ruta = "src/data/Empleados.txt";
  
  public EmpleadoRepository(){
    try{
      this.fileReader = new FileReader(ruta);
      this.bufferedReader = new BufferedReader(this.fileReader);
      this.empleados = new ListaDoble<Usuario>();
      String linea;
      while( (linea = this.bufferedReader.readLine()) != null){
        String[] elementos = linea.split(" ");
        Usuario usuario = new Usuario(
            elementos[0],
            Long.parseLong(elementos[1]),
            new Fecha(
              Short.parseShort(elementos[2]),
              Short.parseShort(elementos[3]),
              Short.parseShort(elementos[4])
            ),
            elementos[5],
            Long.parseLong(elementos[6]),
            elementos[7],
            new Direccion(
              elementos[8],
              elementos[9],
              elementos[10],
              elementos[11],
              elementos[12],
              elementos[13]
            )
            );
        empleados.addLast(usuario);

      }
    }catch(IOException e){
      System.out.println(e); 
    }finally{
      try{
        this.bufferedReader.close();
        this.fileReader.close();
      }catch(IOException e){
        System.out.println(e);
      }
    }
  }

  @Override
  public void save(Usuario usuario){
    try{

        this.fileWriter = new FileWriter(this.ruta,true);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);

        this.bufferedWriter.write(
            usuario.getNombre() + " " +
            usuario.getId() + " " +
            usuario.getFecha().getDia() + " " +
            usuario.getFecha().getMes() + " " +
            usuario.getFecha().getA() + " " +
            usuario.getCiudad_nacimiento() + " " +
            usuario.getTel() + " " +
            usuario.getEmail() + " " +
            usuario.getDireccion().getCalle() + " " +
            usuario.getDireccion().getNomenclatura() + " " +
            usuario.getDireccion().getBarrio() + " " +
            usuario.getDireccion().getCiudad() + " " +
            usuario.getDireccion().getEdificio() + " " +
            usuario.getDireccion().getApto()
        );
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush(); 
        this.empleados.addLast(usuario);
      }
    catch(IOException e){
      System.out.println(e);
    }finally{
      try{
        this.bufferedWriter.close();
        this.fileWriter.close();
      }catch(IOException e){
        System.out.println(e);
      }
    }
  }

  @Override
  public ListaDoble<Usuario> loadAll(){
    return this.empleados;
  }

  @Override
  public Usuario loadById(long id){
    NodoDoble<Usuario> cabeza = this.empleados.getHead();
    while(cabeza != null){
      if(cabeza.getData().getId() == id){
        return cabeza.getData();
      }
      cabeza = cabeza.getNext();
    }
    return new Usuario();
  }
  
  @Override
  public void deleteById(long id){
    NodoDoble<Usuario> cabeza = this.empleados.getHead();
    try{
      this.fileWriter = new FileWriter(this.ruta,false);
    }catch(IOException e){
      System.out.println(e);
    }
    while(cabeza != null){
      if(cabeza.getData().getId() == id){
        if(cabeza == this.empleados.getHead()){
          this.empleados.removeFist();
        }else if(cabeza == this.empleados.getTail()){
          this.empleados.removeLast();
        }else{
          this.empleados.remove(cabeza);
        }
      }
      cabeza = cabeza.getNext();
    }
    cabeza = this.empleados.getHead();
    int nodos = this.empleados.getSize();
    for(int i = 0; i<nodos; i++){
      this.save(cabeza.getData());
      cabeza = cabeza.getNext();
    }
  }

}
