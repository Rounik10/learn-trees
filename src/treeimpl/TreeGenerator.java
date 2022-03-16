package treeimpl;

public class TreeGenerator {

    /**
     * 1
     * 2          3
     * 4     5           6
     */

    public static Node getTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        return root;
    }
}
