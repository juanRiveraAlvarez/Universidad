public class OrdenadoAgenda {
    private ListaDoble L;

    public OrdenadoAgenda() {
        this.L = new ListaDoble();
    }

    public void agregarUsuario(Usuario u) {
        this.L.addLast(u);
    }

    public void ordenar() {
        if (this.L.getHead() != null && this.L.getHead().getNext() != null) {
            this.L.setHead(mergeSortRec(this.L.getHead()));
            NodoDoble tail = this.L.getHead();
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            this.L.setTail(tail);
        }
    }

    private NodoDoble mergeSortRec(NodoDoble head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        NodoDoble middle = getMiddle(head);
        NodoDoble nextToMiddle = middle.getNext();

        middle.setNext(null);
        if (nextToMiddle != null) {
            nextToMiddle.setPrev(null);
        }

        NodoDoble left = mergeSortRec(head);
        NodoDoble right = mergeSortRec(nextToMiddle);

        return merge(left, right);
    }

    private NodoDoble merge(NodoDoble left, NodoDoble right) {
        NodoDoble sorted = new NodoDoble(null);
        NodoDoble current = sorted;

        while (left != null && right != null) {
            if (((Usuario) left.getData()).getId() <= ((Usuario) right.getData()).getId()) {
                current.setNext(left);
                left.setPrev(current);
                left = left.getNext();
            } else {
                current.setNext(right);
                right.setPrev(current);
                right = right.getNext();
            }
            current = current.getNext();
        }

        while (left != null) {
            current.setNext(left);
            left.setPrev(current);
            left = left.getNext();
            current = current.getNext();
        }

        while (right != null) {
            current.setNext(right);
            right.setPrev(current);
            right = right.getNext();
            current = current.getNext();
        }

        sorted.getNext().setPrev(null);
        return sorted.getNext();
    }

    private NodoDoble getMiddle(NodoDoble head) {
        if (head == null) {
            return head;
        }

        NodoDoble slow = head;
        NodoDoble fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    public void mostrar() {
        NodoDoble nodo = this.L.getHead();
        while (nodo != null) {
            System.out.println(nodo.getData().toString());
            nodo = nodo.getNext();
        }
    }
}
