public class Nodo<T>{
  private T data;
  private Nodo<T> izquierdo;
  private Nodo<T> derecho;

  public Nodo(){

  }

  public Nodo(T e){
    this.data = e;
  }
  
  public Nodo<T> getIzquierdo(){
    return this.izquierdo;
  }

  public Nodo<T> getDerecho(){
    return this.derecho;
  }

  public T getData(){
    return this.data;
  }

  public void setIzquierdo(Nodo n){
    this.izquierdo = n; 
  }

  public void setDerecho(Nodo n){
    this.derecho = n; 
  }

  public void setData(T e){
    this.data = e; 
  }

    public Nodo<T> getNext() {
        return this.derecho;
    }

    public void setNext(Nodo<T> n) {
        this.derecho = n;
    }


}
