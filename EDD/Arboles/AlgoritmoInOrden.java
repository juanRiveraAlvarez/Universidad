public class AlgoritmoInOrden{
  public static void inOrden(BinaryTree a, Nodo v){
    if(a.tieneIzquierdo(v)){
      inOrden(a,a.izquierdo(v));
    }
    System.out.println(v.getData());
    if(a.tieneDerecho(v)){
      inOrden(a,a.derecho(v));
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
    inOrden(binaryTree,A);
  }
}

