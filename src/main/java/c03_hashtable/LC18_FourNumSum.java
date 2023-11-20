package c03_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * link: https://leetcode.cn/problems/4sum/description/
 */
public class LC18_FourNumSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int index1 = 0; index1 < nums.length - 3; index1++) {
            if (nums[index1] > 0 && nums[index1] > target) {
                break;
            }
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }
            for (int index2 = index1 + 1; index2 < nums.length - 2; index2++) {
                if (nums[index1] + nums[index2] > 0 && nums[index1] + nums[index2] > target) {
                    break;
                }
                if (index2 > index1 + 1 && nums[index2] == nums[index2 - 1]) {
                    continue;
                }
                long aSum = nums[index1] + nums[index2];
                long needNum = target - aSum;
                int index3 = index2 + 1;
                int index4 = nums.length - 1;
                while (index3 < index4) {
                    long bSum = nums[index3] + nums[index4];
                    if (bSum < needNum) {
                        index3++;
                    } else if (bSum > needNum) {
                        index4--;
                    } else {
                        result.add(Arrays.asList(nums[index1], nums[index2], nums[index3], nums[index4]));
                        while (index3 < index4 && nums[index3] == nums[index3 + 1]) index3++;
                        while (index3 < index4 && nums[index4] == nums[index4 - 1]) index4--;
                        index3++;
                        index4--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int target = 0;
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        LC18_FourNumSum lc18_fourNumSum = new LC18_FourNumSum();
        List<List<Integer>> lists = lc18_fourNumSum.fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
