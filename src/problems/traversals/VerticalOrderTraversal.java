package problems.traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
        }
    }

    static class Pair implements Comparable<Pair> {
        TreeNode node;
        int hd;
        int lev;

        Pair(TreeNode node, int hd, int lev) {
            this.node = node;
            this.hd = hd;
            this.lev = lev;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.lev != that.lev) return this.lev - that.lev;
            return this.node.val - that.node.val;
        }
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Pair>> map = new TreeMap<>();

        traverse(root, map);

        // After traversal the map will contain:
        //      keys: horizontal distance from root (Line)
        //      value: Priority queue of nodes on a given line arranged as defined in Pair class

        List<List<Integer>> ans = new LinkedList<>();
        for (int key : map.keySet()) {
            var x = map.get(key);
            List<Integer> line = new LinkedList<>();
            while (!x.isEmpty()) line.add(x.poll().node.val);
            ans.add(line);
        }
        return ans;
    }

    static void traverse(TreeNode root, Map<Integer, PriorityQueue<Pair>> map) {
        Queue<Pair> q = new LinkedList<>();
        if (root != null) q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode cur = pair.node;
            int line = pair.hd;
            int level = pair.lev;
            addIntoMap(pair, map);
            if (cur.left != null) q.add(new Pair(cur.left, line - 1, level + 1));
            if (cur.right != null) q.add(new Pair(cur.right, line + 1, level + 1));
        }
    }

    private static void addIntoMap(Pair node, Map<Integer, PriorityQueue<Pair>> map) {
        if (map.containsKey(node.hd)) map.get(node.hd).add(node);
        else {
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            queue.offer(node);
            map.put(node.hd, queue);
        }
    }
}