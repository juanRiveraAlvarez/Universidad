public class NodoSimple<T>{

  private T data;
  private NodoSimple<T> next;
  
  public NodoSimple(){

  }

  public NodoSimple(T data){
    this.data = data;
  }

  public void setData(T data){
    this.data = data;
  }

  public T getData(){
    return this.data;
  }

  public void setNext(NodoSimple<T> next){
    this.next = next;
  }

  public NodoSimple<T> getNext(){
    return this.next;
  }

}
