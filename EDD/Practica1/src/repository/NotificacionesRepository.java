package repository;

import model.dto.NotificacionDto;
import model.ListaDoble;
import model.NodoDoble;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class NotificacionesRepository{
  
  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;
  private ListaDoble notificaciones;
  private String ruta = "src/data/Notificaciones.txt";
  
  public NotificacionesRepository(){
    try{
      this.fileReader = new FileReader(ruta);
      this.bufferedReader = new BufferedReader(this.fileReader);
      this.notificaciones = new ListaDoble<NotificacionDto>();
      String linea;
      while( (linea = this.bufferedReader.readLine()) != null){
        String[] elementos = linea.split(" ");
        NotificacionDto notificacionDto = new NotificacionDto(Long.parseLong(elementos[0]),Long.parseLong(elementos[1]),elementos[2]);
        notificaciones.addLast(notificacionDto);
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

  public void save(NotificacionDto notificacionDto){
    try{

        this.fileWriter = new FileWriter(this.ruta,true);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);

        this.bufferedWriter.write(notificacionDto.getIdUsuario()+" "+notificacionDto.getIdEquipo()+" "+notificacionDto.getEstado());
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush(); 
        this.notificaciones.addLast(notificacionDto);
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

  public ListaDoble<NotificacionDto> loadAll(){
    return this.notificaciones;
  }

  public NotificacionDto loadById(long idUsuario, long idEquipo){
    NodoDoble<NotificacionDto> cabeza = this.notificaciones.getHead();
    while(cabeza != null){
      if(cabeza.getData().getIdUsuario() == idUsuario && cabeza.getData().getIdEquipo() == idEquipo){
        return cabeza.getData();
      }
      cabeza = cabeza.getNext();
    }
    return new NotificacionDto();
  }
  
  public ListaDoble<NotificacionDto> loadByIdUser(long idUser){
    ListaDoble<NotificacionDto> solicitudesById = new ListaDoble<NotificacionDto>();
    NodoDoble<NotificacionDto> cabeza = this.notificaciones.getHead();
    while(cabeza != null){
      if(cabeza.getData().getIdUsuario() == idUser){
        solicitudesById.addLast(cabeza.getData());
      }
      cabeza = cabeza.getNext();
    }
    return solicitudesById;
  }
  
  public void deleteById(long idUsuario, long idEquipo){
    NodoDoble<NotificacionDto> cabeza = this.notificaciones.getHead();
    try{
      this.fileWriter = new FileWriter(this.ruta,false);
    }catch(IOException e){
      System.out.println(e);
    }
    while(cabeza != null){
      if(cabeza.getData().getIdUsuario() == idUsuario && cabeza.getData().getIdEquipo() == idEquipo){
        if(cabeza == this.notificaciones.getHead()){
          this.notificaciones.removeFist();
        }else if(cabeza == this.notificaciones.getTail()){
          this.notificaciones.removeLast();
        }else{
          this.notificaciones.remove(cabeza);
        }
      }
      cabeza = cabeza.getNext();
    }
    cabeza = this.notificaciones.getHead();
    int nodos = this.notificaciones.getSize();
    for(int i = 0; i<nodos; i++){
      this.save(cabeza.getData());
      cabeza = cabeza.getNext();
    }
  }

}
