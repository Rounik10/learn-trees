package treeimpl.traversals;

import treeimpl.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Inorder {

    public static List<Integer> inorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        inorderUtil(root, ans);
        return ans;
    }

    private static void inorderUtil(Node root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.data);
        inorderUtil(root.left, ans);
        inorderUtil(root.right, ans);
    }

    public static List<Integer> inorderItr(Node root) {
        List<Integer> ans = new LinkedList<>();
        Stack<Node> st = new Stack<>();
        Node cur = root;

        while (true) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                if (st.isEmpty()) break;
                cur = st.pop();
                ans.add(cur.data);
                if (cur.left != null) st.push(cur.left);
                if (cur.right != null) st.push(cur.right);
            }
        }

        return ans;
    }

}
