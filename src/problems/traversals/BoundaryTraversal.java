package problems.traversals;

import treeimpl.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    private static boolean isLeaf(Node node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }

    private static void addLeftBoundary(Node root, List<Integer> ans) {
        if (root == null || isLeaf(root)) return;
        ans.add(root.data);
        if (root.left == null) addLeftBoundary(root.right, ans);
        else addLeftBoundary(root.left, ans);
    }

    private static void addRightBoundary(Node root, List<Integer> ans) {
        if (root == null || isLeaf(root)) return;
        Stack<Integer> st = new Stack<>();
        Node cur = root;

        while (!isLeaf(cur)) {
            st.push(cur.data);
            if (cur.right != null) cur = cur.right;
            else if (cur.left == null) break;
            else cur = cur.left;
        }
        while (!st.isEmpty()) ans.add(st.pop());
    }

    private static void addLeaves(Node node, List<Integer> ans) {
        if (node == null) return;
        addLeaves(node.left, ans);
        if (isLeaf(node)) ans.add(node.data);
        addLeaves(node.right, ans);
    }

    public static ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) return ans;
        ans.add(node.data);
        if (isLeaf(node)) return ans;

        addLeftBoundary(node.left, ans);
        addLeaves(node, ans);
        addRightBoundary(node.right, ans);

        return ans;
    }

}
