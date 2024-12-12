import  java.util.Scanner;

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

  public static void main(String[] args){

    ListaSimple l1 = new ListaSimple();

    for(int i = 0; i<=11; i++){
      l1.addLast(i*2);
    }
    
    NodoSimple fist = l1.getHead();
    while(fist.getNext() != null){
      System.out.println(fist.getData());
      fist = fist.getNext();
    }
      
    System.out.println("Lista eliminada");
    
    fist = l1.getHead();
    while(fist.getNext() != null){
      if(fist.getNext().getData().equals(Integer.valueOf(1)) || fist.getNext().getData().equals(Integer.valueOf(10))){
        fist.setNext(fist.getNext().getNext());
      }else if(fist.getNext().getData().equals(Integer.valueOf(20))){
        l1.removeLast();
      }
      fist = fist.getNext();
    }
    
    fist = l1.getHead();
    while(fist.getNext() != null){
      System.out.println(fist.getData());
      fist = fist.getNext();
    }

    ListaSimple l2 = new ListaSimple();

    Usuario u1 = new Usuario("Usuario1",1);
    Usuario u2 = new Usuario("Usuario2",2);
    Usuario u3 = new Usuario("Usuario3",3);
    Usuario u4 = new Usuario("Usuario4",4);
    Usuario u5 = new Usuario("Usuario5",5);

    l2.addLast(u1);
    l2.addLast(u2);
    l2.addLast(u3);
    l2.addLast(u4);
    l2.addLast(u5);

    fist = l2.getHead();
    System.out.println(fist.getData().toString());
    while(fist.getNext() != null){
      fist = fist.getNext();
      System.out.println(fist.getData().toString());
    }

    System.out.println("Inserte un nombre de usuario para insertar al final");
    Scanner sc = new Scanner(System.in);
    String nombre = sc.nextLine();
    l2.addLast(new Usuario(nombre,6));
    
    System.out.println("Inserte un nombre de usuario para insertar al principio");
    sc = new Scanner(System.in);
    nombre = sc.nextLine();
    l2.addFist(new Usuario(nombre,7));

    fist = l2.getHead();
    System.out.println(fist.getData().toString());
    while(fist.getNext() != null){
      fist = fist.getNext();
      System.out.println(fist.getData().toString());
    }

    
  }

}
