package repository;

import model.dto.LoginDto;
import model.ListaDoble;
import model.NodoDoble;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class LoginRepository implements PersistenceInterface<LoginDto>{


  private FileReader fileReader;
  private BufferedReader bufferedReader;
  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;
  private ListaDoble credenciales;
  private String ruta = "src/data/Password.txt";
  
  public LoginRepository(){
    try{
      this.fileReader = new FileReader(ruta);
      this.bufferedReader = new BufferedReader(this.fileReader);
      this.credenciales = new ListaDoble<LoginDto>();
      String linea;
      while( (linea = this.bufferedReader.readLine()) != null){
        String[] elementos = linea.split(" ");
        LoginDto loginDto = new LoginDto(Long.parseLong(elementos[0]),elementos[1],elementos[2]);
        credenciales.addLast(loginDto);
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
  public void save(LoginDto loginDto){
    try{

        this.fileWriter = new FileWriter(this.ruta,true);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);

        this.bufferedWriter.write(loginDto.getId()+" "+loginDto.getPassword()+" "+loginDto.getRol());
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush(); 
        this.credenciales.addLast(loginDto);
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
  public ListaDoble<LoginDto> loadAll(){
    return this.credenciales;
  }

  @Override
  public LoginDto loadById(long id){
    NodoDoble<LoginDto> cabeza = this.credenciales.getHead();
    while(cabeza != null){
      if(cabeza.getData().getId() == id){
        return cabeza.getData();
      }
      cabeza = cabeza.getNext();
    }
    return new LoginDto();
  }
  
  @Override
  public void deleteById(long id){
    NodoDoble<LoginDto> cabeza = this.credenciales.getHead();
    try{
      this.fileWriter = new FileWriter(this.ruta,false);
    }catch(IOException e){
      System.out.println(e);
    }
    while(cabeza != null){
      if(cabeza.getData().getId() == id){
        if(cabeza == this.credenciales.getHead()){
          this.credenciales.removeFist();
        }else if(cabeza == this.credenciales.getTail()){
          this.credenciales.removeLast();
        }else{
          this.credenciales.remove(cabeza);
        }
      }
      cabeza = cabeza.getNext();
    }
    cabeza = this.credenciales.getHead();
    int nodos = this.credenciales.getSize();
    for(int i = 0; i<nodos; i++){
      this.save(cabeza.getData());
      cabeza = cabeza.getNext();
    }
  }

}
