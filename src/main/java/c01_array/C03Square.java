package c01_array;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * link: https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 */
public class C03Square {

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = result.length-1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left]*nums[left++];
            }else{
                result[index--] = nums[right]*nums[right--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = C03Square.sortedSquares(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
