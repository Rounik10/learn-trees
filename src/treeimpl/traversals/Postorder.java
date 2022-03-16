package treeimpl.traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import treeimpl.Node;

public class Postorder {

    /**
     * Recursive method to get postorder of binary tree
     *
     * @param root is the root of BST
     * @return Post order traversal of BST
     */
    public static List<Integer> postorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        postorderUtil(root, ans);
        return ans;
    }

    /**
     * Utility function to get postorder of tree
     *
     * @param root is the root of binary tree
     * @param ans  is the list which will contains traversal
     */
    private static void postorderUtil(Node root, List<Integer> ans) {
        if (root == null) return;
        postorderUtil(root.left, ans);
        postorderUtil(root.right, ans);
        ans.add(root.data);
    }

    /**
     * Using 2 stacks
     *
     * @param root is the root of binary tree
     * @return Inorder traversal of binary tree
     */
    static List<Integer> postorderItr(Node root) {

        Stack<Node> st = new Stack<>();
        List<Integer> ans = new LinkedList<>();
        if (root != null) st.push(root);

        while (!st.isEmpty()) {
            Node cur = st.pop();
            ans.add(0, cur.data);
            if (cur.left != null) st.push(cur.left);
            if (cur.right != null) st.push(cur.right);
        }

        return ans;
    }

    /**
     * Preorder traversal using single stack
     *
     * @param root is the root of binary tree
     * @return postorder traversal of binary tree
     */
    static List<Integer> oneStackPostorder(Node root) {
        Stack<Node> st = new Stack<>();
        Node cur = root, prev = null;
        List<Integer> ans = new LinkedList<>();

        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.peek();
                if (cur.right == null || cur.right == prev) {
                    ans.add(st.pop().data);
                    prev = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
        }

        return ans;
    }

}