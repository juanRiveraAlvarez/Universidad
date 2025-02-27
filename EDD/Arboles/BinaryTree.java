public class BinaryTree<T>{
  private Nodo<T> root;
  private int size;

  public BinaryTree(){
    this.size = 0;
  }

  public int size(){
    return this.size;
  }

  public boolean isEmpty(){
    if(this.size == 0){
      return true;
    }else{
      return false;
    }
  }

  public boolean isRoot(Nodo v){
    if(v == this.root){
      return true;
    }else{
      return false;
    }
  }

  public boolean isInternal(Nodo v){
    if((v.getIzquierdo() != null || v.getDerecho() != null)){
      return true;
    }else{
      return false;
    }
  }
  
  public boolean tieneIzquierdo(Nodo<T> v){
    if(v.getIzquierdo() != null){
      return true;
    }else{
      return false;
    }
  }
  
  public boolean tieneDerecho(Nodo<T> v){
    if(v.getDerecho() != null){
      return true;
    }else{
      return false;
    }
  }

  public Nodo<T> root(){
    return this.root;
  }

  public Nodo<T> izquierdo(Nodo<T> v){
    return v.getIzquierdo();
  }
  
  public Nodo<T> derecho(Nodo<T> v){
    return v.getDerecho();
  }

  public Nodo<T> padre(Nodo<T> v){
    if(this.isRoot(v)){
      return null;
    }else{
      Cola Q = new Cola<T>();
      Q.enqueue(this.root);
      Nodo<T> temp = root;
      while(!Q.isEmpty() && this.izquierdo(Q.first()) != v && this.derecho(Q.first()) != v){
        temp = Q.dequeue();
        if(this.tieneIzquierdo(temp)){
          Q.enqueue(this.izquierdo(temp));
        }
        if(this.tieneDerecho(temp)){
          Q.enqueue(this.derecho(temp));
        }
      }
      return temp;
    }
  }

  public void addRoot(Nodo<T> v){
    this.root = v; 
    this.size = this.size + 1;
  }

  public int profundidad(Nodo<T> v){
    if(this.isRoot(v)){
      return 0;
    }else{
      return 1 + profundidad(this.padre(v));
    }
  }
  
  public int altura(Nodo<T> v){
    if(!this.isInternal(v)){
      return 0;
    }else{
      int a = 0;
      a = Math.max(altura(this.izquierdo(v)),altura(this.derecho(v)));
      return 1 + a;
    }
  }

  public void insertIzquierda(Nodo<T> v, T e){
    v.setIzquierdo(new Nodo<T>(e));
    this.size++;
  }
  
  public void insertDerecha(Nodo<T> v, T e){
    v.setDerecho(new Nodo<T>(e));
    this.size++;
  }

  public void remove(Nodo<T> v){
    Nodo<T> p = this.padre(v);
    if( this.tieneIzquierdo(v) || this.tieneDerecho(v)){
      Nodo<T> hijo;
      if(this.tieneIzquierdo(v)){
        hijo = v.getIzquierdo();
      }else{
        hijo = v.getDerecho();
      }
      if(p.getIzquierdo() == v){
        p.setIzquierdo(hijo);
      }else{
        p.setDerecho(hijo);
      }
      v.setDerecho(null);
      v.setIzquierdo(null);
    }else{
      if(p.getIzquierdo() == v){
        p.setIzquierdo(null);
      }else{
        p.setDerecho(null);
      }
    }
    this.size--;
  }
/*
  public static void main(String[] args){
    Nodo A = new Nodo<String>("A");
    Nodo B = new Nodo<String>("B");
    Nodo C = new Nodo<String>("C");
    Nodo D = new Nodo<String>("D");
    Nodo E = new Nodo<String>("E");
    Nodo F = new Nodo<String>("F");
    Nodo G = new Nodo<String>("G");
    A.setIzquierdo(B);

    A.setDerecho(C);
    B.setIzquierdo(D);
    B.setDerecho(E);
    C.setIzquierdo(F);
    C.setDerecho(G);

    BinaryTree binaryTree = new BinaryTree<String>();

    binaryTree.addRoot(A);
    binaryTree.insertIzquierda(A,"B");
    binaryTree.insertDerecha(A,"C");
    binaryTree.insertIzquierda(binaryTree.root().getIzquierdo(),"D");
    binaryTree.insertDerecha(binaryTree.root().getIzquierdo(),"E");
    binaryTree.insertIzquierda(binaryTree.root().getDerecho(),"F");
    binaryTree.insertDerecha(binaryTree.root().getDerecho(),"G");

   // System.out.println(binaryTree.padre(binaryTree.root().getIzquierdo().getIzquierdo()));
    System.out.println(binaryTree.altura(binaryTree.root().getDerecho().getDerecho()));
    System.out.println(binaryTree.profundidad(binaryTree.root().getDerecho().getDerecho()));
    binaryTree.remove(binaryTree.root().getDerecho().getDerecho());
    System.out.println(binaryTree.size());
    binaryTree.remove(binaryTree.root().getIzquierdo().getIzquierdo());
    System.out.println(binaryTree.size());
  }
*/

}
