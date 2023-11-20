package c03_hashtable;

import java.util.HashMap;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * link: https://leetcode.cn/problems/4sum-ii/description/
 */
public class LC454_FourNumSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int lastNum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:nums1){
            for (int j:nums2){
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }
        for (int i:nums3){
            for (int j:nums4){
                lastNum+=map.getOrDefault(-i-j,0);
            }
        }
        return lastNum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, num2 = {-2, -1}, num3 = {-1, 2}, num4 = {0, 2};
        LC454_FourNumSumII lc454_fourNumSumII = new LC454_FourNumSumII();
        int result = lc454_fourNumSumII.fourSumCount(nums1, num2, num3, num4);
        System.out.println(result);
    }
}
