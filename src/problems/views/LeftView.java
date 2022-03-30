package problems.views;

import treeimpl.Node;
import treeimpl.TreeGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {

    static List<Integer> leftView(Node root) {
        List<Integer> ans = new LinkedList<>();
        leftViewRec(root, 0, ans);
        return ans;
    }

    private static void leftViewRec(Node root, int level, List<Integer> ans) {
        if (root == null) return;
        if (level == ans.size()) ans.add(root.data);
        leftViewRec(root.left, level + 1, ans);
        leftViewRec(root.right, level + 1, ans);
    }

    static List<Integer> getLeftView(Node root) {
        List<Integer> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i == 0) ans.add(cur.data);
                if (cur == null) break;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var root = TreeGenerator.getTree();
        var first = getLeftView(root);
        var second = leftView(root);
        System.out.println(first);
        System.out.println(second);
    }

}