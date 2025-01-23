package repository;

import model.Equipo;
import model.dto.SolicitudEliminarEquipoDto;
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

public class SolicitudEliminarRepository{
  
  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;
  private ListaDoble solicitudes;
  private String ruta = "src/data/Solicitudes_eliminar.txt";
  
  public SolicitudEliminarRepository(){
    try{
      this.fileReader = new FileReader(this.ruta);
      this.bufferedReader = new BufferedReader(this.fileReader);
      this.solicitudes = new ListaDoble<SolicitudEliminarEquipoDto>();
      String linea;
      while( (linea = this.bufferedReader.readLine()) != null){
        String[] elementos = linea.split(" ");
        String[] parrafos = linea.split("_");
        SolicitudEliminarEquipoDto solicitud = new SolicitudEliminarEquipoDto(elementos[0], Long.parseLong(elementos[1]), Long.parseLong(elementos[2]), parrafos[1] );
        solicitudes.addLast(solicitud);
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

  public void save(SolicitudEliminarEquipoDto solicitud){
    try{

        this.fileWriter = new FileWriter(this.ruta,true);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);
        this.bufferedWriter.write(solicitud.getNombre()+" "+solicitud.getId()+" "+solicitud.getCodigoEquipo()+" _ "+solicitud.getDescripcion());
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush(); 
        this.solicitudes.addLast(solicitud);
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

  public ListaDoble<SolicitudEliminarEquipoDto> loadAll(){
    return this.solicitudes;
  }

  public SolicitudEliminarEquipoDto loadById(long id, long idEquipo){
    NodoDoble<SolicitudEliminarEquipoDto> cabeza = this.solicitudes.getHead();
    while(cabeza != null){
      if(cabeza.getData().getId() == id && cabeza.getData().getCodigoEquipo() == idEquipo){
        return cabeza.getData();
      }
      cabeza = cabeza.getNext();
    }
    return new SolicitudEliminarEquipoDto();
  }
  
  public void deleteById(long id, long idEquipo){
    NodoDoble<SolicitudEliminarEquipoDto> cabeza = this.solicitudes.getHead();
    try{
      this.fileWriter = new FileWriter(this.ruta,false);
    }catch(IOException e){
      System.out.println(e);
    }
    while(cabeza != null){
      if(cabeza.getData().getId() == id && cabeza.getData().getCodigoEquipo() == idEquipo){
        if(cabeza == this.solicitudes.getHead()){
          this.solicitudes.removeFist();
        }else if(cabeza == this.solicitudes.getTail()){
          this.solicitudes.removeLast();
        }else{
          this.solicitudes.remove(cabeza);
        }
      }
      cabeza = cabeza.getNext();
    }
    cabeza = this.solicitudes.getHead();
    int nodos = this.solicitudes.getSize();
    for(int i = 0; i<nodos; i++){
      this.save(cabeza.getData());
      cabeza = cabeza.getNext();
    }
  }


}

