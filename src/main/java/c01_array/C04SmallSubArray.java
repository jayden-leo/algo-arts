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
public class C04SmallSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength,right-left+1);
                sum -= nums[left++];
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = C04SmallSubArray.minSubArrayLen(7, nums);
        System.out.println(result);
    }
}
