public class Node {
    int key;
    Object data;
    Node left, right;
    
    public Node(int key, Object data) {
        this.key = key;
        this.data = data;
        this.left = this.right = null;
    }
}

