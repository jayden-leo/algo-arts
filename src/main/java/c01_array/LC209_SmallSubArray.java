package c01_array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * link: https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 */
public class LC209_SmallSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int curSum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                minLen = Math.min(minLen, right - left+1);
                curSum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        LC209_SmallSubArray c04SmallSubArray = new LC209_SmallSubArray();
        int i = c04SmallSubArray.minSubArrayLen(7, nums);
        System.out.println(i);
    }
}
