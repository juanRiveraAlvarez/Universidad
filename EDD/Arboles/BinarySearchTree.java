public class BinarySearchTree<BSTEntry> extends BinaryTree<BSTEntry>{
  
  public BinarySearchTree(){

  }
  
  public Nodo find(int k){
    return searchTree(k,super.root());
  }
  
  public  Nodo<BSTEntry> searchTree(int k, Nodo<BSTEntry> v){
    BSTEntry u = v.getData();
    if(k == u.getKey()){
      return v;
    }else if(k<u.getKey()){
      return searchTree(k,v.getIzquierdo());
    }else{
      return searchTree(k,v.getDerecho());
    }
  }

  public void insert(BSTEntry e, int k){
    BSTEntry o = new BSTEntry<T>(e,k);
    if(super.isEmpty()){
      super.addRoot(o);
    }else{
      addEntry(super.root, o);
    }
  }

  public void addEntry(Nodo<BSTEntry> v, BSTEntry o){
    BSTEntry temp = v.getData();
    Nodo nd = new Nodo<BSTEntry>(o);
    if(o.getKey() < temp.getKey()){
      if(super.tieneIzquierdo(v)){
        addEntry(v.getIzquierdo(),o);
      }else{
        v.setIzquierdo(nd);
      }
    }else{
      if(super.tieneDerecho(v)){
        addEntry(v.getDerecho(),o);
      }else{
        v.setDerecho(nd);
      }
    }
  }

  public static Nodo maxNode(Nodo temp){
    if(temp.tieneDerecho()){
      return maxNode(temp.getDerecho());
    }else{
      return temp; 
    }
  }

  public static Nodo predecesor(Nodo v){
    Nodo<BSTEntry> temp = temp.getLeft();
    return maxNode(temp);
  }

  public BSTEntry remove(int k){
    Nodo<BSTEntry> v = find(k);
    BSTEntry temp = v.getData();
    if(v.tieneIzquierdo() && v.tieneDerecho()){
      Nodo<BSTEntry> w = predecesor(v);
      v.setData(w.getData());
      super.remove(w);
    }else{
      super.remove(v);
    }
    return temp;
  }
  
  public static void main(String[] args){

  }

}
