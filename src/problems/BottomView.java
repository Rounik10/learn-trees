package problems;

import treeimpl.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    List<Integer> getBottomView(Node root) {
        TreeMap<Integer, Pair> map = new TreeMap<>();
        traverse(root, map);
        List<Integer> ans = new ArrayList<>();
        for (Pair pair : map.values()) ans.add(pair.node.data);
        return ans;
    }

    private static class Pair {
        int line;
        Node node;

        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    void traverse(Node root, Map<Integer, Pair> map) {
        Queue<Pair> q = new LinkedList<>();
        if (root != null) q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            // For top view:
            // if(!map.containsKey(line)) map.put(cur.line, cur);
            // If map does not contain the current line we add it.
            map.put(cur.line, cur);
            if (cur.node.left != null) q.add(new Pair(cur.node.left, cur.line - 1));
            if (cur.node.right != null) q.add(new Pair(cur.node.right, cur.line + 1));
        }
    }

}
