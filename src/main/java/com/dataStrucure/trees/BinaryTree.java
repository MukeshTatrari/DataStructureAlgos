package com.dataStrucure.trees;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


@Slf4j
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

        tree.preOrderTraversalUsingStack(tree.rootNode);
        System.out.print("\n");
        tree.inOrderTraversalUsingStack(tree.rootNode);
        System.out.print("\n");
//        tree.postOrderTraversalUsingStack(tree.rootNode);

        log.info("level order traversal ::: ");
        tree.levelOrderTraverSal(tree.rootNode);
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

    public void preOrderTraversalUsingStack(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print("  root ::: " + node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inOrderTraversalUsingStack(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = rootNode;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print("  root :: " + temp.data);
                temp = temp.right;
            }
        }
    }

    public void postOrderTraversalUsingStack(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = rootNode;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                temp = temp.right;
                System.out.print("  root :: " + temp.data);
            }
        }
    }


    public void inOderTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        inOderTraversal(rootNode.left);
        System.out.print("  root :: " + rootNode.data);
        inOderTraversal(rootNode.right);
    }

    public void postOderTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        postOderTraversal(rootNode.left);
        postOderTraversal(rootNode.right);
        System.out.print("  root :: " + rootNode.data);
    }

    public void levelOrderTraverSal(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(rootNode);
        if (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print("Node :: " + node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
