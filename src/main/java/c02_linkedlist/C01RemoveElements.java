package c02_linkedlist;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * link: https://leetcode.cn/problems/remove-linked-list-elements/description/
 */
public class C01RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy; // 要连接的节点
        ListNode cur = head; // 当前判断的节点
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode head = C01RemoveElements.removeElements(listNode, 6);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
