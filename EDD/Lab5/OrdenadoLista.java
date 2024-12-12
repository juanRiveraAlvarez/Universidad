class OrdenadorLista {

  private ListaSimple L;

  public OrdenadorLista() {
    this.L = new ListaSimple();
  }

  public ListaSimple getL() {
    return this.L;
  }

  public void setL(ListaSimple L) {
    this.L = L;
  }

  public void inicializar(int n) {
    for (int i = 0; i < n; i++) {
      this.L.addLast((int) (Math.random() * 100) + 1);
    }
  }

  public void ordenar() {
    if (this.L.getHead() != null && this.L.getHead().getNext() != null) {
      this.L.setHead(mergeSortRec(this.L.getHead()));
    }
  }

  private NodoSimple mergeSortRec(NodoSimple head) {
    if (head == null || head.getNext() == null) {
      return head;
    }

    NodoSimple middle = getMiddle(head);
    NodoSimple nextToMiddle = middle.getNext();

    middle.setNext(null);

    NodoSimple left = mergeSortRec(head);
    NodoSimple right = mergeSortRec(nextToMiddle);

    return merge(left, right);
  }

  private NodoSimple merge(NodoSimple left, NodoSimple right) {
    NodoSimple sorted = new NodoSimple(null);
    NodoSimple current = sorted;

    while (left != null && right != null) {
      if ((int) left.getData() <= (int) right.getData()) {
        current.setNext(left);
        left = left.getNext();
      } else {
        current.setNext(right);
        right = right.getNext();
      }
      current = current.getNext();
    }

    if (left != null) {
      current.setNext(left);
    } else if (right != null) {
      current.setNext(right);
    }

    return sorted.getNext();
  }

  private NodoSimple getMiddle(NodoSimple head) {
    if (head == null) {
      return head;
    }

    NodoSimple slow = head;
    NodoSimple fast = head;

    while (fast.getNext() != null && fast.getNext().getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }

    return slow;
  }

  public void mostrar() {
    NodoSimple temp = this.L.getHead();
    while (temp != null) {
      System.out.println(temp.getData());
      temp = temp.getNext();
    }
  }

}
