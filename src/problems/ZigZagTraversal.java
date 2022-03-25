package problems;

import treeimpl.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();

        if (root != null) q.add(root);
        boolean rev = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lev = new LinkedList<>();
            while (size-- > 0) {
                Node cur = q.poll();
                if (cur == null) break;
                if (rev) lev.add(0, cur.data);
                else lev.add(cur.data);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            ans.add(lev);
            rev = !rev;
        }

        return ans;
    }
}
