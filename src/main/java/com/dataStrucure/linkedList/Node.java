package com.dataStrucure.linkedList;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Node {
    int data;
    Node previous;
    Node next;
    int length;

    Node(int data) {
        this.data = data;
    }


    public void print(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ====> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public Node insertAtBeginning(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        } else {
            node.next = head;
            head.previous = node;
            return node;
        }
    }

    public Node insertAtEnd(Node tailNode, int data) {
        Node node = new Node(data);
        if (tailNode == null) {
            tailNode = node;
            return tailNode;
        } else {
            tailNode.next = node;
            node.previous = tailNode;
        }
        return node;
    }

    public Node deleteAtBeginning(Node head, Node tail) {
        if (head == null) {
            return head;
        }
        Node temp = head;
        if (head == tail) {
            tail =null;
        }else{
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        return head;
    }
}
