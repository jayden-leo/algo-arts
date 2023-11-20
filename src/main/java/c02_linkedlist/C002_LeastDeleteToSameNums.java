package c02_linkedlist;

import java.util.HashMap;
import java.util.Set;

public class C002_LeastDeleteToSameNums {
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
        C002_LeastDeleteToSameNums c002_leastDeleteToSameNums = new C002_LeastDeleteToSameNums();
        ListNode solve = c002_leastDeleteToSameNums.solve(head);
        while(solve!=null){
            System.out.print(solve.val+" ");
            solve = solve.next;
        }

    }
}
