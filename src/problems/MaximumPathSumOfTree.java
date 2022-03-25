package problems;

import treeimpl.Node;

public class MaximumPathSumOfTree {

    public static int getMaxPathSum(Node root) {
        int[] max = {Integer.MIN_VALUE};
        calculate(root, max);
        return max[0];
    }

    private static int calculate(Node root, int[] max) {
        if (root == null) return 0;

        int lh = Math.max(0, calculate(root.left, max));
        int rh = Math.max(0, calculate(root.right, max));

        // Calculating maximum
        max[0] = Math.max(lh + rh + root.data, max[0]);

        // Taking the best path including the root.data
        return Math.max(lh, rh) + root.data;
    }

}
