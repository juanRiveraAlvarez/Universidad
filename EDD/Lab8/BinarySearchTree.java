public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int key, Object data) {
        root = insertRec(root, key, data);
    }

    private Node insertRec(Node root, int key, Object data) {
        if (root == null) {
            return new Node(key, data);
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key, data);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, data);
        }
        return root;
    }

    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    public Node findMin() {
        Node current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node findMax() {
        Node current = root;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public void printTree() {
        printTreeRec(root, 0);
    }

    private void printTreeRec(Node root, int space) {
        if (root == null) return;
        space += 5;
        printTreeRec(root.right, space);
        System.out.println(" ".repeat(space) + root.key);
        printTreeRec(root.left, space);
    }
}

