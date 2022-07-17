package com.dataStrucure.trees;

public class BinaryTree {
    private TreeNode rootNode;

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();
        tree.print(tree.rootNode);
        System.out.print("preOrder Traversal ");
        tree.preOderTraversal(tree.rootNode);
        System.out.print("\n");
        System.out.print("inOrder Traversal ");
        tree.inOderTraversal(tree.rootNode);
        System.out.print("\n");
        System.out.print("postOrder Traversal ");
        tree.postOderTraversal(tree.rootNode);
        System.out.print("\n");
    }

    public void createBinaryTree() {
        TreeNode firstNode = new TreeNode(1);
        TreeNode secondNode = new TreeNode(2);
        TreeNode thirdNode = new TreeNode(3);
        TreeNode fourthNode = new TreeNode(4);
        TreeNode fifthNode = new TreeNode(5);
        rootNode = firstNode;

        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;
        secondNode.right = fifthNode;
    }

    public void print(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.print(" root ::: " + rootNode.data);
        String left = rootNode.left != null ? String.valueOf(rootNode.left.data) : "null";
        String right = rootNode.right != null ? String.valueOf(rootNode.right.data) : "null";

        System.out.print(" left ::: " + left);
        System.out.print(" right ::: " + right);
        System.out.print("\n");
        print(rootNode.left);
        print(rootNode.right);
    }

    public void preOderTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.print("  root :: " + rootNode.data);
        preOderTraversal(rootNode.left);
        preOderTraversal(rootNode.right);
    }

    public void inOderTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        preOderTraversal(rootNode.left);
        System.out.print("  root :: " + rootNode.data);
        preOderTraversal(rootNode.right);
    }

    public void postOderTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        preOderTraversal(rootNode.left);
        preOderTraversal(rootNode.right);
        System.out.print("  root :: " + rootNode.data);
    }
}
