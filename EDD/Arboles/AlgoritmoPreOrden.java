public class AlgoritmoPreOrden{
  public static void preOrden(BinaryTree<String> a, Nodo<String> v){
    System.out.println(v.getData());
    if(a.tieneIzquierdo(v)){
      preOrden(a,a.izquierdo(v));
    }
    if(a.tieneDerecho(v)){
      preOrden(a,a.derecho(v));
    }
  }

  public static void main(String[] args){
    BinaryTree binaryTree = new BinaryTree<String>();
    Nodo A = new Nodo<String>("A");
    binaryTree.addRoot(A);
    binaryTree.insertIzquierda(A,"B");
    binaryTree.insertDerecha(A,"C");
    binaryTree.insertIzquierda(binaryTree.root().getIzquierdo(),"D");
    binaryTree.insertDerecha(binaryTree.root().getIzquierdo(),"E");
    binaryTree.insertIzquierda(binaryTree.root().getDerecho(),"F");
    binaryTree.insertDerecha(binaryTree.root().getDerecho(),"G");
    preOrden(binaryTree,binaryTree.root());
  }
}
