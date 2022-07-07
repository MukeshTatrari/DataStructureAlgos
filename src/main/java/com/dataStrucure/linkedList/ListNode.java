package com.dataStrucure.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void print(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.data + " ===> ");
            head = head.next;
        }
        System.out.print("null \n");
    }

    public int countElement(ListNode head) {
        int count = 0;
        if (head == null) {
            return 0;
        }
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode insertAtBeginning(ListNode head, int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
        return head;
    }

    public void insertAtEnd(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        while (null != head.next) {
            head = head.next;
        }
        head.next = node;
    }

    public void insertAtGivenPosition(ListNode head, int position, int data) {
        ListNode node = new ListNode(data);
        if (position == 1) {
            node.next = head;
            head = node;
        }
        int count = 1;
        ListNode previous = head;
        while (count < position - 1) {
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        node.next = current;
        previous.next = node;


    }

    public ListNode deleteNodeFromBeginning(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    public void deleteLastNode(ListNode head) {
        if (head == null) {
            return;
        }
        while (head.next.next != null) {
            head = head.next;
        }
        head.next = null;
    }

    public ListNode deleteAtGivenPosition(ListNode head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 1) {
            head = head.next;
            return head;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            previous.next = previous.next.next;
            return head;
        }
    }
}
