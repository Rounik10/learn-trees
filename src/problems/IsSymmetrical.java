package problems;

import treeimpl.Node;

public class IsSymmetrical {

    static boolean isSymmetrical(Node tree) {
        if (tree == null) return true;
        return isMirrorImage(tree.left, tree.right);
    }

    private static boolean isMirrorImage(Node left, Node right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.data != right.data) return false;
        return isMirrorImage(left.right, right.left) && isMirrorImage(left.left, right.right);
    }
}
