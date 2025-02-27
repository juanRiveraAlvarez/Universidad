public class AlgoritmoPostOrden{
  public static void postOrden(BinaryTree a, Nodo v){
    if(a.tieneIzquierdo(v)){
      postOrden(a,a.izquierdo(v));
    }
    if(a.tieneDerecho(v)){
      postOrden(a,a.derecho(v));
    }
    System.out.println(v.getData());
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
    postOrden(binaryTree,A);
  }
}
