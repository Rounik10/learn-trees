package problems;

import treeimpl.Node;

import static problems.HeightOfTree.getHeight;

public class BalancedTree {

    // Time complexity for this will be O(N^2)
    public boolean isBalanced(Node root) {
        if (root == null) return true;

        //
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isBalancedOptimized(Node root) {
        return isBalancedOptimizedUtil(root) != -1;
    }

    private int isBalancedOptimizedUtil(Node root) {
        if (root == null) return 0;

        int left = isBalancedOptimizedUtil(root.left);
        int right = isBalancedOptimizedUtil(root.right);

        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

}
