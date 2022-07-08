package com.dataStrucure.linkedList;

public class SinglyLinkedList {

    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(2);
        ListNode secondListNode = new ListNode(5);
        ListNode thirdListNode = new ListNode(8);
        ListNode forthListNode = new ListNode(11);

        singlyLinkedList.head.next = secondListNode;
        secondListNode.next = thirdListNode;
        thirdListNode.next = forthListNode;
        forthListNode.next = secondListNode;

        ListNode ls = new ListNode();
//        ls.print(singlyLinkedList.head);
//        int length = ls.countElement(singlyLinkedList.head);
//        System.out.println("total elements in list ::: " + length);
//        ListNode newHead = ls.insertAtBeginning(singlyLinkedList.head, 20);
//        ls.print(newHead);
//        newHead = ls.insertAtBeginning(newHead, 30);
//        ls.print(newHead);
//        ls.insertAtEnd(singlyLinkedList.head, 60);
//        ls.print(singlyLinkedList.head);
//        ls.insertAtGivenPosition(singlyLinkedList.head, 2, 96);
//        ls.print(singlyLinkedList.head);
//        newHead = ls.deleteNodeFromBeginning(singlyLinkedList.head);
//        ls.print(newHead);
//
//        ls.deleteLastNode(newHead);
//        ls.print(newHead);
//        ListNode head1 = ls.deleteAtGivenPosition(newHead, 1);
//        ls.print(head1);
//
//        boolean isPresent = ls.searchKey(head1, 8);
//        System.out.println("key  present in linked list ::: " + isPresent);
//        ListNode reverseHead = ls.reverse(head1);
//        ls.print(reverseHead);

//        ListNode middle = ls.findMiddle(singlyLinkedList.head);
//        System.out.println("MiddleNode ::: "+middle.data);
//        ListNode node = ls.findNthNodeFromEnd2(singlyLinkedList.head, 3);
//        System.out.println("nth Node from last  ::: "+node.data);
//        ls.removeDuplicateFromSortedList(singlyLinkedList.head);
//        ls.print(singlyLinkedList.head);
//        ls.insertInSortedLinkedList(singlyLinkedList.head, 12);
//        ls.print(singlyLinkedList.head);
//        ls.removeGivenNode(singlyLinkedList.head, 12);
//        ls.print(singlyLinkedList.head);

        System.out.println("is Loop present ::: " + ls.checkIfLoop(singlyLinkedList.head));
        System.out.println("starting Node of the loop :: " + ls.startingNodeOfLoop(singlyLinkedList.head).data);
        ls.removeLoopIfPresent(singlyLinkedList.head);
        ls.print(singlyLinkedList.head);
    }
}
