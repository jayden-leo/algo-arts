package c03_hashtable;

import java.util.HashSet;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * link: https://leetcode.cn/problems/intersection-of-two-arrays/description/
 */
public class LC349_ArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            if (s1.contains(i)){
                s2.add(i);
            }
        }
        int count = 0;
        int[] result = new int[s2.size()];
        for (Integer integer : s2) {
            result[count++] = integer;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        LC349_ArrayIntersection lc349_arrayIntersection = new LC349_ArrayIntersection();
        int[] result = lc349_arrayIntersection.intersection(num1, num2);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
