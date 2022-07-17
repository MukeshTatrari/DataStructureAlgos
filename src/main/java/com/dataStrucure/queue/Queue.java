package com.dataStrucure.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue {

    private ListNode rear;
    private ListNode front;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enQueue(int data) {
        ListNode temp = new ListNode(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " ====> ");
            current = current.next;
        }
        System.out.print("null \n");
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int node = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return node;
    }

    public String[] generateBinaryNumbers(int n) {
        String[] arr = new String[n];
        java.util.Queue<String> queue = new LinkedList<String>();
        queue.offer("1");
        for(int i=0;i<n;i++){
            arr[i]= queue.poll();
            String n1 = arr[i] + "0";
            String n2 = arr[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }

        return arr;
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(22);
        queue.print();
        queue.deQueue();
        queue.deQueue();
        queue.print();

       String [] numbers= queue.generateBinaryNumbers(7);
       System.out.println(Arrays.toString(numbers));



    }
}
