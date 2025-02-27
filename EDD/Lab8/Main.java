public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7, "Juan");
        tree.insert(4, "Pablo");
        tree.insert(9, "Maria");
        tree.insert(2, "Ana");
        tree.insert(10, "Diana");
        tree.insert(8, "Mateo");
        
        System.out.println("Inorder traversal:");
        tree.inorder();
        
        System.out.println("\nTree structure:");
        tree.printTree();
    }
}

