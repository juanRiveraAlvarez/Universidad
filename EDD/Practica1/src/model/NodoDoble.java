package model;

public class NodoDoble<T>{

  private T data;
  private NodoDoble<T> next;
  private NodoDoble<T> prev;
  
  public NodoDoble(){

  }

  public NodoDoble(T data){
    this.data = data;
  }

  public void setData(T data){
    this.data = data;
  }

  public T getData(){
    return this.data;
  }

  public void setNext(NodoDoble next){
    this.next = next;
  }

  public NodoDoble getNext(){
    return this.next;
  }
  
  public void setPrev(NodoDoble prev){
    this.prev = prev;
  }

  public NodoDoble getPrev(){
    return this.prev;
  }

  public static void main(String[] args){
    System.out.print("Hola mubdo");
  }

}
