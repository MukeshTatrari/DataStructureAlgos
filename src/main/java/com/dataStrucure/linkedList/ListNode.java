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

    public boolean searchKey(ListNode head, int searchKey) {
        if (head == null) {
            return false;
        } else {
            while (head != null) {
                if (searchKey == head.data) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        } else {
            ListNode currentNode = head;
            ListNode previousNode = null;
            ListNode nextNode = null;
            while (currentNode != null) {
                nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }
            return previousNode;
            // 1-->4-->11-->18-->null
        }
    }

    public ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fastPoint = head;
        ListNode slowPointer = head;
        while (fastPoint != null && fastPoint.next != null) {
            slowPointer = slowPointer.next;
            fastPoint = fastPoint.next.next;
        }
        return slowPointer;
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        int count = 1;
        while (current != null) {
            current = current.next;
            count++;
        }
        int middle = count / 2;
        int position = 1;
        ListNode middleNode = head;
        if (middle != 1) {
            while (position <= middle) {
                middleNode = middleNode.next;
                position++;
            }
        }
        return middleNode;
    }

    public ListNode findNthNodeFromEnd(ListNode head, int position) {
        // 1-->4-->11-->18-->null
        if (head == null) {
            return null;
        } else {
            ListNode mainPtr = head;
            ListNode refPtr = head;
            int count = 0;
            while (count < position) {
                refPtr = refPtr.next;
                count++;
            }
            while (refPtr != null) {
                refPtr = refPtr.next;
                mainPtr = mainPtr.next;
            }
            return mainPtr;
        }
    }

    public ListNode findNthNodeFromEnd2(ListNode head, int position) {
        if (head == null) {
            return null;
        }
        ListNode reverse = reverse(head);
        int count = 1;
        while (count < position) {
            reverse = reverse.next;
            count++;
        }
        return reverse;
    }

    public void removeDuplicateFromSortedList(ListNode head) {
        if (head == null) {
            return;
        } else {
            ListNode current = head;
            while (current != null && current.next != null) {
                if (current.data == current.next.data) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }
    }

    public ListNode insertInSortedLinkedList(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return head;
        } else {
            ListNode current = head;
            ListNode temp = null;
            while (current != null && current.data < data) {
                temp = current;
                current = current.next;
            }
            node.next = current;
            temp.next = node;
        }

        return head;
    }

    public void removeGivenNode(ListNode head, int key) {
        if (head == null) {
            return;
        } else {
            ListNode current = head;
            ListNode temp = null;
            while (current != null && current.data != key) {
                temp = current;
                current = current.next;
            }
            if (current == null) {
                return;
            } else {
                temp.next = current.next;
            }
        }
    }

    public boolean checkIfLoop(ListNode head) {
        if (head == null) {
            return false;
        } else {
            ListNode fastPtr = head;
            ListNode slowPtr = head;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                if (slowPtr == fastPtr) {
                    return true;
                }
            }
        }
        return false;
    }

    public ListNode startingNodeOfLoop(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode fastPtr = head;
            ListNode slowPtr = head;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                if (slowPtr == fastPtr) {
                    return getStartingNode(head, slowPtr);
                }
            }
        }
        return null;
    }

    public ListNode getStartingNode(ListNode head, ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr != temp) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void removeLoopIfPresent(ListNode head) {
        if (head == null) {
            return;
        } else {
            ListNode fastPtr = head;
            ListNode slowPtr = head;
            while (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
                if (slowPtr == fastPtr) {
                    removeLoop(head, slowPtr);
                }
            }
        }
    }

    public void removeLoop(ListNode head, ListNode slowPtr) {
        ListNode temp = head;
        while (temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public ListNode mergeLinkedList(ListNode listA, ListNode listB) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (listA != null && listB != null) {
            if (listA.data <= listB.data) {
                tail.next = listA;
                listA = listA.next;
            } else {
                tail.next = listB;
                listB = listB.next;
            }
            tail = tail.next;
        }
        if (listA == null) {
            tail.next = listB;
        } else {
            tail.next = listA;
        }
        return dummy.next;
    }

    public ListNode addLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if(carry>0){
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
