package problems;

import treeimpl.Node;
import treeimpl.TreeGenerator;

public class DiameterOfTree {

    static int maxi = 0;

    static int getDiameter(Node root) {
        maxi = 0;
        calculateHeight(root);
        return maxi;
    }

    private static int calculateHeight(Node root) {
        if (root == null) return 0;

        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);

        maxi = Math.max(maxi, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node root = TreeGenerator.getTree();
        int diam = getDiameter(root);
        System.out.println(diam);
    }

}