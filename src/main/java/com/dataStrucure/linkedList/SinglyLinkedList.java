package com.dataStrucure.linkedList;

import java.util.List;

public class SinglyLinkedList {

    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);
        ListNode secondListNode = new ListNode(1);
        ListNode thirdListNode = new ListNode(8);
        ListNode forthListNode = new ListNode(11);

        singlyLinkedList.head.next = secondListNode;
        secondListNode.next = thirdListNode;
        thirdListNode.next = forthListNode;

        ListNode ls = new ListNode();
        ls.print(singlyLinkedList.head);
        int length = ls.countElement(singlyLinkedList.head);
        System.out.println("total elements in list ::: " + length);
        ListNode newHead = ls.insertAtBeginning(singlyLinkedList.head, 20);
        ls.print(newHead);
        newHead = ls.insertAtBeginning(newHead,30);
        ls.print(newHead);
        ls.insertAtEnd(singlyLinkedList.head, 60);
        ls.print(singlyLinkedList.head);
        ls.insertAtGivenPosition(singlyLinkedList.head, 2,96);
        ls.print(singlyLinkedList.head);
        newHead = ls.deleteNodeFromBeginning(singlyLinkedList.head);
        ls.print(newHead);

        ls.deleteLastNode(newHead);
        ls.print(newHead);
        ListNode head1 = ls.deleteAtGivenPosition(newHead, 1);
        ls.print(head1);

    }
}
