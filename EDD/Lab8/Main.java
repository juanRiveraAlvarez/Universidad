public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7, "Juan");
        tree.insert(4, "Pablo");
        tree.insert(9, "Maria");
        tree.insert(2, "Ana");
        tree.insert(10, "Diana");
        tree.insert(8, "Mateo");

        tree.remove(9);
        System.out.println(tree.findMin(tree.root()).getData());
        System.out.println(tree.findMax(tree.root()).getData());
        
        System.out.println("Inorder traversal:");
        tree.inorder();
        
        System.out.println("Tree structure:");
        tree.printTree();
    }
}

