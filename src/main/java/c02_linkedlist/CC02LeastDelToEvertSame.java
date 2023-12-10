package c02_linkedlist;

import java.util.HashMap;
import java.util.Set;

/**
 * 小红拿到了一个链表。她想知道至少删除多少个节点，可以使得链表所有节点的值都相同。
 * 请你返回个删除后的链表方案。如果有多个合法的解，输出任意即可。
 * 输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入:  1,2,2,3,1
 * 输出:  2,2
 * 说明: 返回 1,1也是可以的。至少需要删除3 个节点。
 */
public class CC02LeastDelToEvertSame {
    public ListNode solve(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode point = head;
        while (point != null) {
            map.put(point.val, map.getOrDefault(point.val, 0) + 1);
            point = point.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int flagNum = 0;
        int maxNum = 0;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Integer num = map.get(key);
            if (num > maxNum) {
                maxNum = num;
                flagNum = key;
            }
        }
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null){
            if (cur.val!=flagNum){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(1)))));
//        ListNode head = new ListNode(5);
        ListNode solve = new CC02LeastDelToEvertSame().solve(head);
        while (solve != null) {
            System.out.print(solve.val + " ");
            solve = solve.next;
        }

    }
}
