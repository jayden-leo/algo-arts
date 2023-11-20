package c09_greedy;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * link: https://leetcode.cn/problems/maximum-subarray/
 */
public class C03_MaximumSubsequenceSum {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            if (sum > result){
                result = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        C03_MaximumSubsequenceSum c03_maximumSubsequenceSum = new C03_MaximumSubsequenceSum();
        int result = c03_maximumSubsequenceSum.maxSubArray(nums);
        System.out.println(result);
    }
}
