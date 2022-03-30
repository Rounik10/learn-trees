package problems.views;

import treeimpl.Node;
import treeimpl.TreeGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    static List<Integer> getRightView(Node root) {
        List<Integer> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur == null) break;
                if (i == size - 1) ans.add(cur.data);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return ans;
    }


    static List<Integer> rightView(Node root) {
        List<Integer> ans = new LinkedList<>();
        rightViewRec(root, 0, ans);
        return ans;
    }

    private static void rightViewRec(Node root, int level, List<Integer> ans) {
        if (root == null) return;
        if (level == ans.size()) ans.add(root.data);
        rightViewRec(root.right, level + 1, ans);
        rightViewRec(root.left, level + 1, ans);
    }

    public static void main(String[] args) {
        var root = TreeGenerator.getTree();
        var first = getRightView(root);
        var second = rightView(root);
        System.out.println(first);
        System.out.println(second);
    }
}
