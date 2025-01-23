package model;

import model.NodoDoble;
import model.Usuario;

import  java.util.Scanner;

public class ListaDoble<T>{
  
  private NodoDoble<T> head;
  private NodoDoble<T> tail;
  private int size;

  public ListaDoble(){
    this.size = 0;
  }

  public int getSize(){
    return this.size;
  }

  public void setHead(NodoDoble head){
    this.head = head;
  }
  
  public void setTail(NodoDoble tail){
    this.tail = tail;
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

  public NodoDoble getHead(){
    return this.head;
  }

  public NodoDoble getTail(){
    return this.tail;
  }
  
  public void addFist(T n){
    NodoDoble aux = this.head;
    this.head = new NodoDoble(n);
    this.head.setNext(aux);
    if(this.size == 0){
      this.tail = this.head;
    }
    this.size = this.size + 1;
  }
  
  public void addLast(T n){
    if(this.size == 0){
      this.tail = new NodoDoble(n);
      this.head = this.tail;
    }else if(size > 0){
      NodoDoble nuevoNodo = new NodoDoble(n);
      this.tail.setNext(nuevoNodo);
      nuevoNodo.setPrev(this.tail);
      this.tail = nuevoNodo;
    }
    this.size = this.size + 1;
  }

  public NodoDoble removeFist(){
    if(this.size > 0){
      this.head = this.head.getNext();
      this.size = this.size - 1;
    }
    return this.head;
  }
  
  public NodoDoble removeLast(){
    NodoDoble aux = this.head;
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

  public boolean remove(NodoDoble n){
    n.getPrev().setNext(n.getNext());
    n.getNext().setPrev(n.getPrev());
    this.size = this.size - 1;
    return true;
  }
  
  public void addAfter(NodoDoble n, T e){
    if(!n.equals(this.tail)){
      NodoDoble aux = n.getNext();
      NodoDoble nd = new NodoDoble(e);
      n.getNext().setPrev(nd);
      n.setNext(nd);
      nd.setPrev(n);
      nd.setNext(aux);
    }else{
      addLast(e);
    }
  }
  
  public void addBefore(NodoDoble n, T e){
    if(!n.equals(this.head)){
      NodoDoble aux = n.getPrev();
      NodoDoble nd = new NodoDoble(e);
      n.getPrev().setNext(nd);
      n.setPrev(nd);
      nd.setPrev(aux);
      nd.setNext(n);
    }else{
      addFist(e);
    }
  }

}
