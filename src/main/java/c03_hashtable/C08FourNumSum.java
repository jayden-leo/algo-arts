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
public class C08FourNumSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i1 = 0; i1 < nums.length - 3; i1++) {
            if (nums[i1] > 0 && nums[i1] > target) {
                break;
            }
            if (i1 != 0 && nums[i1] == nums[i1 - 1]) {
                continue;
            }
            for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                if (nums[i1] + nums[i2] > 0 && nums[i1] + nums[i2] > target) {
                    break;
                }
                if (i2 != i1 + 1 && nums[i2] == nums[i2 - 1]) {
                    continue;
                }
                int left = i2 + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i1] + nums[i2] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i1],nums[i2],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
//        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
//        int target = -294967296;
        C08FourNumSum lc18_fourNumSum = new C08FourNumSum();
        List<List<Integer>> lists = lc18_fourNumSum.fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
