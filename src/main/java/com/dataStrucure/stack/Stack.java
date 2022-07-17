package com.dataStrucure.stack;


import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {
    private ListNode top;
    private int length;


    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public void push(int data) {
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty stack");
        } else {
            int data = top.data;
            top = top.next;
            length--;
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String reverse(String str) {
        java.util.Stack<Character> stacks = new java.util.Stack<Character>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stacks.push(c);

        }
        for (int i = 0; i < str.length(); i++) {
            chars[i] = stacks.pop();
        }

        return new String(chars);
    }

    private int[] nextGreaterElement(int arr[]) {
        int[] result = new int[arr.length];
        java.util.Stack<Integer> integerStack = new java.util.Stack<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!integerStack.isEmpty()) {
                while (!integerStack.isEmpty() && (integerStack.peek() < arr[i])) {
                    integerStack.pop();
                }
            }
            if (integerStack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = integerStack.peek();
            }
            integerStack.push(arr[i]);
        }
        return result;
    }

    public boolean isValid(String string) {
        char[] input = string.toCharArray();
        java.util.Stack<Character> stacks = new java.util.Stack<Character>();
        for (char c : input) {
            if (c == '(' || c == '{' || c == '}') {
                stacks.push(c);
            } else {
                if (stacks.isEmpty()) {
                    return false;
                } else {
                    char top = stacks.peek();
                    if ((c == ')' && top == '(')
                            || (c == '}' && top == '{')
                            || (c == ']' && top == '[')) {
                        stacks.pop();
                    }
                }
            }
        }

        return stacks.isEmpty();
    }

    public boolean isSymetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.data != n2.data) {
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n2.left);
            stack.push(n1.right);
        }


        return true;
    }

    private class TreeNode {
        private int data; // Generic type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);

        int peek = stack.peek();
        System.out.println("peek ::: " + peek);
        int pop = stack.pop();
        System.out.println("pop ::: " + pop);
        int peek1 = stack.peek();
        System.out.println("peek ::: " + peek1);

        String reverse = stack.reverse("mukesh");
        System.out.println("reverse ::: " + reverse);
        int[] data = new int[]{3, 5, 6, 3, 4, 5, 9, 10, 1};
        int[] data1 = stack.nextGreaterElement(data);
        for (int i = 0; i < data1.length; i++) {
            System.out.print(data1[i] + " , ");
        }

        boolean isValid = stack.isValid("(())}{");
        System.out.println("isValid ::: " + isValid);


    }
}
