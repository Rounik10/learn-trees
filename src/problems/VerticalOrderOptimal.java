package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderOptimal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
        }
    }

    List<List<Integer>> getVerticalOrder(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        traverse(root, 0, 0, map);

        List<List<Integer>> ans = new LinkedList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> line : map.values()) {
            List<Integer> ansLine = new LinkedList<>();
            for (PriorityQueue<Integer> level : line.values()) {
                while (!level.isEmpty()) ansLine.add(level.poll());
            }
            ans.add(ansLine);
        }

        return ans;
    }

    private void traverse(TreeNode root, int line, int level, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) return;

        if (!map.containsKey(line)) map.put(line, new TreeMap<>());
        if (!map.get(line).containsKey(level)) map.get(line).put(level, new PriorityQueue<>());
        map.get(line).get(level).add(root.val);

        traverse(root.left, line - 1, level + 1, map);
        traverse(root.right, line + 1, level + 1, map);
    }

    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        return root;
    }

    public static void main(String[] args) {
        new VerticalOrderOptimal().getVerticalOrder(getTree());
    }

}
