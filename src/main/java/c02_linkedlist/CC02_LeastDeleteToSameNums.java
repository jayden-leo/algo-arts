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
public class CC02_LeastDeleteToSameNums {
    public ListNode solve (ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(head!=null){
            if(map.containsKey(head.val)){
                int x = map.get(head.val);
                x++;
                map.put(head.val, x);
            }else{
                map.put(head.val, 1);
            }
            head = head.next;
        }
        int maxNum = -1;
        int flagNum = -1;
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if (map.get(key)>maxNum){
                flagNum = key;
                maxNum = map.get(key);
            }
        }
        head = dummy.next;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null){
            if (cur.val != flagNum){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(3,new ListNode(1)))));
//        ListNode head = new ListNode(5);
        CC02_LeastDeleteToSameNums c002_leastDeleteToSameNums = new CC02_LeastDeleteToSameNums();
        ListNode solve = c002_leastDeleteToSameNums.solve(head);
        while(solve!=null){
            System.out.print(solve.val+" ");
            solve = solve.next;
        }

    }
}
