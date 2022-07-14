package com.dataStrucure.stack;


import java.util.Arrays;
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


    }
}
