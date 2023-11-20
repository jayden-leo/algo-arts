package c02_linkedlist;

/**
 * link: https://leetcode.cn/problems/design-linked-list/description/
 */
class MyLinkedList {
    Integer size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode point = head;
        for (int i = 0; i < index; i++) {
            point = point.next;
        }
        return point.next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size ++;
        ListNode point = head;
        for (int i = 0; i < index; i++) {
            point = point.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = point.next;
        point.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        ListNode point = head;
        for (int i=0;i<index;i++){
            point = point.next;
        }
        point.next = point.next.next;
        size --;
    }

    public void printLinkedList() {
        ListNode point = head.next;
        while (point != null) {
            System.out.print(point.val + " ");
            point = point.next;
        }
        System.out.println();
    }
}

public class LC707_DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.printLinkedList();
        myLinkedList.addAtTail(3);
        myLinkedList.printLinkedList();
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.printLinkedList();
        int i = myLinkedList.get(1);
        System.out.println(i);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.printLinkedList();
        int i1 = myLinkedList.get(1);
        System.out.println(i1);
    }
}
