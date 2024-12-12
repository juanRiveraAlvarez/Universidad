public class NodoDoble{

  private Object data;
  private NodoDoble next;
  private NodoDoble prev;
  
  public NodoDoble(){

  }

  public NodoDoble(Object data){
    this.data = data;
  }

  public void setData(Object data){
    this.data = data;
  }

  public Object getData(){
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

}
