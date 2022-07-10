package com.dataStrucure.linkedList;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularLinkedList() {
        ListNode firstNode = new ListNode(2);
        ListNode secondNode = new ListNode(4);
        ListNode thirdNode = new ListNode(12);
        ListNode forthNode = new ListNode(8);
        ListNode fifthNode = new ListNode(19);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = forthNode;
        forthNode.next = fifthNode;
        last = fifthNode;
        fifthNode.next = firstNode;
    }

    public void print() {
        if (last == null) {
            return;
        }
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " ====> ");
            first = first.next;
        }
        System.out.print(first.data + " \n");
    }

    public void insertAtBeginning(int data) {
        ListNode node = new ListNode(data);
        if (last == null) {
            last = node;
        } else {
            node.next = last.next;
        }
        last.next = node;
        length++;
    }

    public void insertAtLast(int data) {
        ListNode node = new ListNode(data);
        if (last == null) {
            last = node;
            last.next = last;
        } else {
            node.next = last.next;
            last.next = node;
            last = node;
        }
        length++;
    }

    public void removeFirstNode() {
        if (isEmpty()) {
            throw new NoSuchElementException("element not found");
        } else {
            ListNode temp = last.next;
            if (last.next == last) {
                last = null;
            } else {
                last.next = temp.next;

            }
            temp.next = null;
            length--;
        }
    }

    public void removeFromLast() {
        if (last == null) {
            return;
        } else {
            ListNode temp = last;
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            last = temp;

        }
    }

    public static void main(String[] args) {
        CircularLinkedList ls = new CircularLinkedList();
        ls.createCircularLinkedList();
        ls.insertAtBeginning(32);
        ls.insertAtLast(45);
        ls.print();
        ls.removeFirstNode();
        ls.print();
        ls.removeFromLast();
        ls.print();
    }

}
