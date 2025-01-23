package repository;

import model.Equipo;
import model.Fecha;
import model.ListaDoble;
import model.NodoDoble;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

public class EquipoRepository implements PersistenceInterface<Equipo>{
  
  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;
  private ListaDoble equipos;
  private String ruta = "src/data/inventarioEmpleados/";
  
  public EquipoRepository(String nombre, long id){
    this.ruta = ruta+nombre+" "+id+".txt";
    try{
      File verificar = new File(this.ruta);
      if(!verificar.exists()){
        verificar.createNewFile();
      }
      this.fileReader = new FileReader(this.ruta);
      this.bufferedReader = new BufferedReader(this.fileReader);
      this.equipos = new ListaDoble<Equipo>();
      String linea;
      while( (linea = this.bufferedReader.readLine()) != null){
        String[] elementos = linea.split(" ");
        Equipo equipo = new Equipo(elementos[0], Long.parseLong(elementos[1]), new Fecha(Short.parseShort(elementos[2]),Short.parseShort(elementos[3]),Short.parseShort(elementos[4])), Long.parseLong(elementos[5]));
        equipos.addLast(equipo);
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
  public void save(Equipo equipo){
    try{

        this.fileWriter = new FileWriter(this.ruta,true);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);

        this.bufferedWriter.write(equipo.getNombre()+" "+equipo.getId()+" "+equipo.getFecha().getDia()+" "+equipo.getFecha().getMes()+" "+equipo.getFecha().getA()+" "+equipo.getValor());
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush(); 
        this.equipos.addLast(equipo);
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
  public ListaDoble<Equipo> loadAll(){
    return this.equipos;
  }

  @Override
  public Equipo loadById(long id){
    NodoDoble<Equipo> cabeza = this.equipos.getHead();
    while(cabeza != null){
      if(cabeza.getData().getId() == id){
        return cabeza.getData();
      }
      cabeza = cabeza.getNext();
    }
    return new Equipo();
  }
  
  @Override
  public void deleteById(long id){
    NodoDoble<Equipo> cabeza = this.equipos.getHead();
    try{
      this.fileWriter = new FileWriter(this.ruta,false);
    }catch(IOException e){
      System.out.println(e);
    }
    while(cabeza != null){
      if(cabeza.getData().getId() == id){
        if(cabeza == this.equipos.getHead()){
          this.equipos.removeFist();
        }else if(cabeza == this.equipos.getTail()){
          this.equipos.removeLast();
        }else{
          this.equipos.remove(cabeza);
        }
      }
      cabeza = cabeza.getNext();
    }
    cabeza = this.equipos.getHead();
    int nodos = this.equipos.getSize();
    for(int i = 0; i<nodos; i++){
      this.save(cabeza.getData());
      cabeza = cabeza.getNext();
    }
  }


}
