package com.dataStrucure.linkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tailNode;

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.head = new Node(2);
        Node secondListNode = new Node(5);
        Node thirdListNode = new Node(8);
        Node forthListNode = new Node(11);
        doublyLinkedList.tailNode = forthListNode;

        doublyLinkedList.head.next = secondListNode;
        doublyLinkedList.head.previous = null;

        secondListNode.next = thirdListNode;
        secondListNode.previous = doublyLinkedList.head;

        thirdListNode.next = forthListNode;
        thirdListNode.previous = secondListNode;

        forthListNode.next = null;
        forthListNode.previous = thirdListNode;

        Node ls = new Node();
        ls.print(doublyLinkedList.head);
        Node newHead = ls.insertAtBeginning(doublyLinkedList.head, 18);
        ls.print(newHead);
        ls.insertAtEnd(doublyLinkedList.tailNode, 26);
        ls.print(newHead);
        newHead = ls.deleteAtBeginning(newHead, doublyLinkedList.tailNode);
        ls.print(newHead);

    }
}
