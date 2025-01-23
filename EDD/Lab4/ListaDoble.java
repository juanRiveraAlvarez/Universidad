import  java.util.Scanner;

public class ListaDoble{
  
  private NodoDoble head;
  private NodoDoble tail;
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
  
  public void addFist(Object n){
    NodoDoble aux = this.head;
    this.head = new NodoDoble(n);
    this.head.setNext(aux);
    if(this.size == 0){
      this.tail = this.head;
    }
    this.size = this.size + 1;
  }
  
  public void addLast(Object n){
    if(this.size == 0){
      this.tail = new NodoDoble(n);
      this.head = this.tail;
    }else if(size > 0){
      NodoDoble nuevoNodo = new NodoDoble(n);
      this.tail.setNext(nuevoNodo);
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

  public NodoDoble remove(NodoDoble n){
    n.getPrev().setNext(n.getNext());
    n.getNext().setPrev(n.getPrev());
    this.size = this.size + 1;
    return n;
  }
  
  public void addAfter(NodoDoble n, Object e){
    if(!n.equals(this.tail)){
      NodoDoble aux = n.getNext();
      NodoDoble nd = new NodoDoble(e);
      n.getNext().setPrev(nd);
      n.setNext(nd);
      nd.setPrev(n);
      nd.setNext(aux);
    }else{
      addLast(n);
    }
  }
  
  public void addBefore(NodoDoble n, Object e){
    if(!n.equals(this.head)){
      NodoDoble aux = n.getPrev();
      NodoDoble nd = new NodoDoble(e);
      n.getPrev().setNext(nd);
      n.setPrev(nd);
      nd.setPrev(aux);
      nd.setNext(n);
    }else{
      addFist(n);
    }
  }

  public static void main(String[] args){
  
    ListaDoble ld1 = new ListaDoble();
    
    for(int i = 0; i<=11; i++){
      ld1.addLast(i*2);
    }
    
    NodoDoble fist = ld1.getHead();
    while(fist.getNext() != null){
      System.out.println(fist.getData());
      fist = fist.getNext();
    }
    
    System.out.println("Lista eliminada");
    
    fist = ld1.getHead();
    while(fist.getNext() != null){
      if(fist.getNext().getData().equals(Integer.valueOf(1)) || fist.getNext().getData().equals(Integer.valueOf(10))){
        fist.setNext(fist.getNext().getNext());
      }else if(fist.getNext().getData().equals(Integer.valueOf(20))){
        ld1.removeLast();
      }
      fist = fist.getNext();
    }
    System.out.println("Mi lista"); 
    fist = ld1.getHead();
    while(fist.getNext() != null){
      System.out.println(fist.getData());
      fist = fist.getNext();
    }
    System.out.println("-------------"); 

    ListaDoble ld2 = new ListaDoble();

    Usuario u1 = new Usuario("Usuario1",1);
    Usuario u2 = new Usuario("Usuario2",2);
    Usuario u3 = new Usuario("Usuario3",3);
    Usuario u4 = new Usuario("Usuario4",4);
    Usuario u5 = new Usuario("Usuario5",5);

    ld2.addLast(u1);
    ld2.addLast(u2);
    ld2.addLast(u3);
    ld2.addLast(u4);
    ld2.addLast(u5);
    
    fist = ld2.getHead();
    System.out.println(fist.getData().toString());
    while(fist.getNext() != null){
      fist = fist.getNext();
      System.out.println(fist.getData().toString());
    }

    System.out.println("Inserte un nombre de usuario para insertar al final");
    Scanner sc = new Scanner(System.in);
    String nombre = sc.nextLine();
    ld2.addLast(new Usuario(nombre,6));
    
    System.out.println("Inserte un nombre de usuario para insertar al principio");
    nombre = sc.nextLine();
    ld2.addFist(new Usuario(nombre,7));

    fist = ld2.getHead();
    System.out.println(fist.getData().toString());
    while(fist.getNext() != null){
      fist = fist.getNext();
      System.out.println(fist.getData().toString());
    }
    
    System.out.println("Inserte un nombre de usuario para insertar despues del tercer nodo");
    nombre = sc.nextLine();

    int cont = 0;
    fist = ld2.getHead();
    while(fist.getNext() != null){
      if(cont  == 2){
        ld2.addAfter(fist,new Usuario(nombre,8));
        break;
      }
      fist = fist.getNext();
      cont = cont + 1;
    }
    
    fist = ld2.getHead();
    System.out.println(fist.getData().toString());
    while(fist.getNext() != null){
      fist = fist.getNext();
      System.out.println(fist.getData().toString());
    }
    
  }

}
