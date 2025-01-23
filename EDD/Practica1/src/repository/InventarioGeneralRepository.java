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


  public void ordenar() {
    NodoDoble cabeza = this.registros.getHead();
      try{
        this.fileWriter = new FileWriter(this.ruta,false);
      }catch(IOException e){
        System.out.println(e);
      }
      if (this.registros.getHead() != null && this.registros.getHead().getNext() != null) {
            this.registros.setHead(mergeSortRec(this.registros.getHead()));
            NodoDoble tail = this.registros.getHead();
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            this.registros.setTail(tail);
        }
    cabeza = this.registros.getHead();
    int nodos = this.registros.getSize();
    for(int i = 0; i<nodos; i++){
      this.save((InventarioGeneralDto)cabeza.getData());
      cabeza = cabeza.getNext();
    }

    }

    private NodoDoble mergeSortRec(NodoDoble head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        NodoDoble middle = getMiddle(head);
        NodoDoble nextToMiddle = middle.getNext();

        middle.setNext(null);
        if (nextToMiddle != null) {
            nextToMiddle.setPrev(null);
        }

        NodoDoble left = mergeSortRec(head);
        NodoDoble right = mergeSortRec(nextToMiddle);

        return merge(left, right);
    }

    private NodoDoble merge(NodoDoble left, NodoDoble right) {
        NodoDoble sorted = new NodoDoble(null);
        NodoDoble current = sorted;

        while (left != null && right != null) {
            if (((InventarioGeneralDto) left.getData()).getEquipo().getId() <= ((InventarioGeneralDto) right.getData()).getEquipo().getId()) {
                current.setNext(left);
                left.setPrev(current);
                left = left.getNext();
            } else {
                current.setNext(right);
                right.setPrev(current);
                right = right.getNext();
            }
            current = current.getNext();
        }

        while (left != null) {
            current.setNext(left);
            left.setPrev(current);
            left = left.getNext();
            current = current.getNext();
        }

        while (right != null) {
            current.setNext(right);
            right.setPrev(current);
            right = right.getNext();
            current = current.getNext();
        }

        sorted.getNext().setPrev(null);
        return sorted.getNext();
    }

    private NodoDoble getMiddle(NodoDoble head) {
        if (head == null) {
            return head;
        }

        NodoDoble slow = head;
        NodoDoble fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }


}
