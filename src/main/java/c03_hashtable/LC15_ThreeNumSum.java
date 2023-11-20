package c03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * link: https://leetcode.cn/problems/3sum/description/
 */
public class LC15_ThreeNumSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int index1 = 0; index1 < nums.length; index1++) {
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }
            int index2 = index1 + 1;
            int index3 = nums.length - 1;
            while (index2 < index3) {
                int sum = nums[index1] + nums[index2] + nums[index3];
                if (sum > 0) {
                    index3--;
                } else if (sum < 0) {
                    index2++;
                } else {
                    result.add(Arrays.asList(nums[index1], nums[index2], nums[index3]));
                    while (index2 < index3 && nums[index3] == nums[index3 - 1]) index3--;
                    while (index2 < index3 && nums[index2] == nums[index2 + 1]) index2++;
                    index3--;
                    index2++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        LC15_ThreeNumSum lc15_threeNumSum = new LC15_ThreeNumSum();
        List<List<Integer>> lists = lc15_threeNumSum.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
