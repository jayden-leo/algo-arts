package c02_linkedlist;

/**
 * link: https://leetcode.cn/problems/reverse-linked-list/description/
 */
public class LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        LC206_ReverseLinkedList c03ReverseLinkedList = new LC206_ReverseLinkedList();
        ListNode head = c03ReverseLinkedList.reverseList(listNode);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
