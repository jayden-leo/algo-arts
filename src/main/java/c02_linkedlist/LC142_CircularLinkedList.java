package c02_linkedlist;

/**
 * link: https://leetcode.cn/problems/linked-list-cycle-ii/description/
 */
public class LC142_CircularLinkedList {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next != null) {
             fast = fast.next.next;
             slow = slow.next;
             if (fast == slow){
                 slow = head;
                 while(fast != slow){
                     fast = fast.next;
                     slow = slow.next;
                 }
                 return slow;
             }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        LC142_CircularLinkedList c07CircularLinkedList = new LC142_CircularLinkedList();
        ListNode listNode = c07CircularLinkedList.detectCycle(node1);
        System.out.println(listNode.val);
    }
}