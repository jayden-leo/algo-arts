package c09_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * link: https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 *
 * 补充：排序的各种方式
 *
 * 思路：按照最大绝对值排序，然后如果是负数就用K来反转。
 */
public class C07_MaximizedArraySumAfterKTimesNegation {

    public int largestSumAfterKNegations(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        int[] nums = {4,2,3};
        int k = 1;
        C07_MaximizedArraySumAfterKTimesNegation c07_maximizedArraySumAfterKTimesNegation = new C07_MaximizedArraySumAfterKTimesNegation();
        int sum = c07_maximizedArraySumAfterKTimesNegation.largestSumAfterKNegations(nums, k);
        System.out.println(sum);
    }
}
