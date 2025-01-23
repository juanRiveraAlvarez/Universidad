package repository;

import model.Equipo;
import model.dto.SolicitudCargarEquipoDto;
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

public class SolicitudCargarRepository{
  
  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;
  private ListaDoble solicitudes;
  private String ruta = "src/data/Solicitudes_agregar.txt";
  
  public SolicitudCargarRepository(){
    try{
      this.fileReader = new FileReader(this.ruta);
      this.bufferedReader = new BufferedReader(this.fileReader);
      this.solicitudes = new ListaDoble<SolicitudCargarEquipoDto>();
      String linea;
      while( (linea = this.bufferedReader.readLine()) != null){
        String[] elementos = linea.split(" ");
        SolicitudCargarEquipoDto solicitud = new SolicitudCargarEquipoDto(elementos[0], Long.parseLong(elementos[1]), new Equipo(elementos[2], Long.parseLong(elementos[3]), new Fecha(Short.parseShort(elementos[4]), Short.parseShort(elementos[5]), Short.parseShort(elementos[6])), Long.parseLong(elementos[7])));
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

  public void save(SolicitudCargarEquipoDto solicitud){
    try{

        this.fileWriter = new FileWriter(this.ruta,true);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);

        this.bufferedWriter.write(solicitud.getNombre()+" "+solicitud.getId()+" "+solicitud.getEquipo().getNombre()+" "+solicitud.getEquipo().getId()+" "+solicitud.getEquipo().getFecha().getDia()+" "+solicitud.getEquipo().getFecha().getMes()+" "+solicitud.getEquipo().getFecha().getA()+" "+solicitud.getEquipo().getValor());
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

  public ListaDoble<SolicitudCargarEquipoDto> loadAll(){
    return this.solicitudes;
  }

  public SolicitudCargarEquipoDto loadById(long id, long idEquipo){
    NodoDoble<SolicitudCargarEquipoDto> cabeza = this.solicitudes.getHead();
    while(cabeza != null){
      if(cabeza.getData().getId() == id && cabeza.getData().getEquipo().getId() == idEquipo){
        return cabeza.getData();
      }
      cabeza = cabeza.getNext();
    }
    return new SolicitudCargarEquipoDto();
  }
  
  
  public void deleteById(long id, long idEquipo){
    NodoDoble<SolicitudCargarEquipoDto> cabeza = this.solicitudes.getHead();
    try{
      this.fileWriter = new FileWriter(this.ruta,false);
    }catch(IOException e){
      System.out.println(e);
    }
    while(cabeza != null){
      if(cabeza.getData().getId() == id && cabeza.getData().getEquipo().getId() == idEquipo){
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
