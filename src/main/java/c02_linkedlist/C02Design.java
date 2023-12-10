package c02_linkedlist;

import java.util.List;

/**
 * link: https://leetcode.cn/problems/design-linked-list/description/
 */
public class C02Design {

    static class MyLinkedList {

        ListNode head;
        int size;

        public MyLinkedList() {
            head = new ListNode(-1);
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode point = head.next;
            for (int i = 0; i < index; i++) {
                point = point.next;
            }
            return point.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            ListNode point = head;
            ListNode newNode = new ListNode(val);
            for (int i = 0; i < index; i++) {
                point = point.next;
            }
            newNode.next = point.next;
            point.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index<0||index>=size){
                return;
            }
            ListNode point = head;
            for (int i=0;i<index;i++){
                point = point.next;
            }
            point.next = point.next.next;
            size--;
        }


        public void printLinkedList() {
            ListNode point = head.next;
            while(point!=null){
                System.out.print(point.val+" ");
                point = point.next;
            }
            System.out.println();
        }
    }

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
