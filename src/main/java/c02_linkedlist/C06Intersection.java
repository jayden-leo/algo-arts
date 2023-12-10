package c02_linkedlist;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * link: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/
 */
public class C06Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        int lenA = 0;
        int lenB = 0;
        while (pointA != null) {
            pointA = pointA.next;
            lenA++;
        }
        while (pointB != null) {
            pointB = pointB.next;
            lenB++;
        }
        if (lenA < lenB) {
            pointA = headB;
            pointB = headA;
        } else {
            pointA = headA;
            pointB = headB;
        }
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            pointA = pointA.next;
        }
        while(pointA!=null){
            if (pointA==pointB){
                return pointA;
            }
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return null;
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
        ListNode intersectionNode = new C06Intersection().getIntersectionNode(headA, headB);
        System.out.println(intersectionNode != null ? intersectionNode.val : null);
    }
}
