package c02_linkedlist;

/**
 * link: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/
 */
public class LC207_Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode point1 = headA;
        ListNode point2 = headB;
        int list1Len = 0;
        int list2Len = 0;
        while (point1 != null) {
            list1Len++;
            point1 = point1.next;
        }
        while (point2 != null) {
            list2Len++;
            point2 = point2.next;
        }
        point1 = headA;
        point2 = headB;
        ListNode temp;
        if (list1Len > list2Len) {
            temp = point1;
            point1 = point2;
            point2 = temp;
        }
        int moveNum = Math.abs(list1Len - list2Len);
        for (int i = 0; i < moveNum; i++) {
            point2 = point2.next;
        }
        while (point2 != null && point1 != point2) {
            point1 = point1.next;
            point2 = point2.next;
        }
        return point2;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4, new ListNode(1));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1)));
        ListNode headCommon = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode point1 = headA;
        ListNode point2 = headB;
        while (point1.next != null) {
            point1 = point1.next;
        }
        while (point2.next != null) {
            point2 = point2.next;
        }
        point1.next = headCommon;
        point2.next = headCommon;
        LC207_Intersection c06LinkedListIntersection = new LC207_Intersection();
        ListNode intersectionNode = c06LinkedListIntersection.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
}
