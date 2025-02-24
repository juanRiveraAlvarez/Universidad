public class Cola<T>{
  
  private ListaSimple<T> data;

  public Cola(){
    this.data = new ListaSimple<T>();
  }

  public int size(){
    return this.data.getSize();
  }

  public boolean isEmpty(){
    if(this.data == null || this.data.getSize() == 0){
      return true;
    }else{
      return false;
    }
  }

  public void enqueue(Nodo<T> e){
    this.data.addLast(e);
  }

  public Nodo<T> dequeue(){
    return this.data.removeFist();
  }

  public Nodo<T> first(){
    return this.data.getHead();
  }

}
