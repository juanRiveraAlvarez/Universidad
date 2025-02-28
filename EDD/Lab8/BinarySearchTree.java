public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node root(){
      return this.root;
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

    public void remove(int key) {
        root = removeRec(root, key);
    }

    public Node removeRec(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = removeRec(root.left, key);
        } else if (key > root.key) {
            root.right = removeRec(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node minNode = findMin(root.right);
            root.key = minNode.key;
            root.data = minNode.data;
            root.right = removeRec(root.right, minNode.key);
        }
        return root;
    }

    public Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node findMax(Node root) {
        while (root.right != null) {
            root = root.right;
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

