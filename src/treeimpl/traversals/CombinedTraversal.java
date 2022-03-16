package treeimpl.traversals;

import treeimpl.Node;
import treeimpl.TreeGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CombinedTraversal {

    private static class Pair {
        Node node;
        int number;

        Pair(Node node, int number) {
            this.node = node;
            this.number = number;
        }
    }

    static void printTraversals(Node root) {
        Stack<Pair> st = new Stack<>();
        List<Integer> preorder = new LinkedList<>();
        List<Integer> inorder = new LinkedList<>();
        List<Integer> postorder = new LinkedList<>();

        st.push(new Pair(root, 0));

        while (!st.isEmpty()) {
            Pair cur = st.pop();

            if (cur.number == 0) {
                cur.number++;
                st.push(cur);
                preorder.add(cur.node.data);
                if (cur.node.left != null) st.push(new Pair(cur.node.left, 0));
            } else if (cur.number == 1) {
                cur.number++;
                st.push(cur);
                inorder.add(cur.node.data);
                if (cur.node.right != null) st.push(new Pair(cur.node.right, 0));
            } else {
                postorder.add(cur.node.data);
            }
        }

        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }

    public static void main(String[] args) {
        var root = TreeGenerator.getTree();
        printTraversals(root);
    }

}
