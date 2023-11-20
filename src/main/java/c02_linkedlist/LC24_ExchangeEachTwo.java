package c02_linkedlist;

/**
 * link: https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class LC24_ExchangeEachTwo {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        LC24_ExchangeEachTwo c04ExchangeElementEachTwo = new LC24_ExchangeEachTwo();
        head = c04ExchangeElementEachTwo.swapPairs(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
