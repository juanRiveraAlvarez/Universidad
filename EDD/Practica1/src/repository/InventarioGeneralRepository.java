package repository;

import model.Equipo;
import model.dto.InventarioGeneralDto;
import model.Fecha;
import model.ListaDoble;
import model.NodoDoble;
import model.Usuario;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class InventarioGeneralRepository{
  
  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;
  private ListaDoble registros;
  private String ruta = "src/data/InventarioGeneral.txt";
  
  public InventarioGeneralRepository(){
    try{
      this.fileReader = new FileReader(this.ruta);
      this.bufferedReader = new BufferedReader(this.fileReader);
      this.registros = new ListaDoble<InventarioGeneralDto>();
      String linea;
      while( (linea = this.bufferedReader.readLine()) != null){
        String[] elementos = linea.split(" ");
        InventarioGeneralDto registro = new InventarioGeneralDto(elementos[0], Long.parseLong(elementos[1]), new Equipo(elementos[2], Long.parseLong(elementos[3]), new Fecha(Short.parseShort(elementos[4]), Short.parseShort(elementos[5]), Short.parseShort(elementos[6])), Long.parseLong(elementos[7])));
        registros.addLast(registro);
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

  public void save(InventarioGeneralDto registro){
    try{

        this.fileWriter = new FileWriter(this.ruta,true);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);

        this.bufferedWriter.write(registro.getNombre()+" "+registro.getIdUsuario()+" "+registro.getEquipo().getNombre()+" "+registro.getEquipo().getId()+" "+registro.getEquipo().getFecha().getDia()+" "+registro.getEquipo().getFecha().getMes()+" "+registro.getEquipo().getFecha().getA()+" "+registro.getEquipo().getValor());
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush(); 
        this.registros.addLast(registro);
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

  public ListaDoble<InventarioGeneralDto> loadAll(){
    return this.registros;
  }

  public InventarioGeneralDto loadById(long id, long idEquipo){
    NodoDoble<InventarioGeneralDto> cabeza = this.registros.getHead();
    while(cabeza != null){
      if(cabeza.getData().getIdUsuario() == id && cabeza.getData().getEquipo().getId() == idEquipo){
        return cabeza.getData();
      }
      cabeza = cabeza.getNext();
    }
    return new InventarioGeneralDto();
  }
  
  
  public void deleteById(long id, long idEquipo){
    NodoDoble<InventarioGeneralDto> cabeza = this.registros.getHead();
    try{
      this.fileWriter = new FileWriter(this.ruta,false);
    }catch(IOException e){
      System.out.println(e);
    }
    while(cabeza != null){
      if(cabeza.getData().getIdUsuario() == id && cabeza.getData().getEquipo().getId() == idEquipo){
        if(cabeza == this.registros.getHead()){
          this.registros.removeFist();
        }else if(cabeza == this.registros.getTail()){
          this.registros.removeLast();
        }else{
          this.registros.remove(cabeza);
        }
      }
      cabeza = cabeza.getNext();
    }
    cabeza = this.registros.getHead();
    int nodos = this.registros.getSize();
    for(int i = 0; i<nodos; i++){
      this.save(cabeza.getData());
      cabeza = cabeza.getNext();
    }
  }


}
