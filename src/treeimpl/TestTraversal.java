package treeimpl;

import treeimpl.traversals.Inorder;
import treeimpl.traversals.Postorder;
import treeimpl.traversals.Preorder;

public class TestTraversal {

    public static void main(String[] args) {
        Node root = TreeGenerator.getTree();
        var preorder = Preorder.preorder(root);
        var inorder = Inorder.inorder(root);
        var postorder = Postorder.postorder(root);

        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }
}