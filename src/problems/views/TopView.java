package problems.views;

import treeimpl.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopView {

    List<Integer> getTopView(Node root) {
        TreeMap<Integer, Pair> map = new TreeMap<>();
        traverse(root, 0, 0, map);
        List<Integer> ans = new ArrayList<>();
        for (Pair pair : map.values()) {
            ans.add(pair.node.data);
        }
        return ans;
    }

    private static class Pair {
        int line, level;
        Node node;

        Pair(Node node, int line, int level) {
            this.node = node;
            this.level = level;
            this.line = line;
        }
    }


    void traverse(Node root, int level, int line, Map<Integer, Pair> map) {
        if (root == null) return;
        if (!map.containsKey(line) || map.get(line).level > level) {
            map.put(line, new Pair(root, line, level));
        }
        traverse(root.left, level + 1, line - 1, map);
        traverse(root.right, level + 1, line + 1, map);
    }

}
