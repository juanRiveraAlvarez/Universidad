public class ListaSimple<T>{
  
  private Nodo<T> head;
  private Nodo<T> tail;
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

  public Nodo<T> getHead(){
    return this.head;
  }

  public void setHead(Nodo head){
    this.head = head;
  }

  public Nodo getTail(){
    return this.tail;
  }
  
  public void addFist(T n){
    Nodo aux = this.head;
    this.head = new Nodo(n);
    this.head.setDerecho(aux);
    if(this.size == 0){
      this.tail = this.head;
    }
    this.size = this.size + 1;
  }
  
  public void addLast(Nodo<T> n){
    if(this.size == 0){
      this.tail = n;
      this.head = this.tail;
    }else if(size > 0){
      this.tail.setDerecho(n);
      this.tail = n;
    }
    this.size = this.size + 1;
  }

  public Nodo<T> removeFist(){
    if(this.size > 0){
      this.head = this.head.getDerecho();
      this.size = this.size - 1;
    }
    return this.head;
  }
  
  public Nodo<T> removeLast(){
    Nodo<T> aux = this.head;
    if(this.size == 1){
      this.head = null;
      this.tail = null;
      this.size = this.size - 1;
    }else if(this.size > 0){
      while(aux.getDerecho() != this.tail){
        aux = aux.getDerecho();
      }
      aux.setDerecho(null);
      this.tail = aux;
      this.size = this.size - 1;
    }
    return aux;
  }

}
