package problems;

import treeimpl.Node;
import treeimpl.TreeGenerator;

public class HeightOfTree {

    static int getHeight(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        Node root = TreeGenerator.getTree();
        var height = getHeight(root);
        System.out.println("Height is: " + height);
    }

}
