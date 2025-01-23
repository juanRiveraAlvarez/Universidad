public class NodoSimple{

  private Object data;
  private NodoSimple next;
  
  public NodoSimple(){

  }

  public NodoSimple(Object data){
    this.data = data;
  }

  public void setData(Object data){
    this.data = data;
  }

  public Object getData(){
    return this.data;
  }

  public void setNext(NodoSimple next){
    this.next = next;
  }

  public NodoSimple getNext(){
    return this.next;
  }

}
