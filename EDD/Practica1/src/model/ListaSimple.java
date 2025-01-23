package model;


public class ListaSimple{
  
  private NodoSimple head;
  private NodoSimple tail;
  private int size;

  public ListaSimple(){
    this.size = 0;
  }

  public int getSize(){
    return this.size;
  }

  public boolean isEmpty(){
    if(this.head == null && this.tail == null){
      return true;
    }else{
      return false;
    }
  }

  public void setSize(int size){
    this.size = size;
  }

  public NodoSimple getHead(){
    return this.head;
  }

  public void setHead(NodoSimple head){
    this.head = head;
  }

  public NodoSimple getTail(){
    return this.tail;
  }
  
  public void addFist(Object n){
    NodoSimple aux = this.head;
    this.head = new NodoSimple(n);
    this.head.setNext(aux);
    if(this.size == 0){
      this.tail = this.head;
    }
    this.size = this.size + 1;
  }
  
  public void addLast(Object n){
    if(this.size == 0){
      this.tail = new NodoSimple(n);
      this.head = this.tail;
    }else if(size > 0){
      NodoSimple nuevoNodo = new NodoSimple(n);
      this.tail.setNext(nuevoNodo);
      this.tail = nuevoNodo;
    }
    this.size = this.size + 1;
  }

  public NodoSimple removeFist(){
    if(this.size > 0){
      this.head = this.head.getNext();
      this.size = this.size - 1;
    }
    return this.head;
  }
  
  public NodoSimple removeLast(){
    NodoSimple aux = this.head;
    if(this.size > 0){
      while(aux.getNext() != this.tail){
        aux = aux.getNext();
      }
      aux.setNext(null);
      this.tail = aux;
      this.size = this.size - 1;
    }
    return aux;
  }

}
