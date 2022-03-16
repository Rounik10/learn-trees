package treeimpl.traversals;

import treeimpl.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Preorder {

    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        preorderUtil(root, ans);
        return ans;
    }

    private static void preorderUtil(Node root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.data);
        preorderUtil(root.left, ans);
        preorderUtil(root.right, ans);
    }

    public static List<Integer> preorderItr(Node root) {
        List<Integer> ans = new LinkedList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node cur = st.pop();
            ans.add(cur.data);
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }

        return ans;
    }

}
