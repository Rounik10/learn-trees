package problems;

import treeimpl.Node;

public class LowestCommonAncestor {

    Node getLca(Node root, Node first, Node second) {
        if (root == null || root == first || root == second) return root;

        Node left = getLca(root.left, first, second);
        Node right = getLca(root.right, first, second);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

}
