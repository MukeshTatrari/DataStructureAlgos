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


    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);

        int peek= stack.peek();
        System.out.println("peek ::: "+peek);
        int pop = stack.pop();
        System.out.println("pop ::: "+pop);
        int peek1= stack.peek();
        System.out.println("peek ::: "+peek1);
    }
}
