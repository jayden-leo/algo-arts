package c09_greedy;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * link: https://leetcode.cn/problems/jump-game-ii/
 *
 * 技巧：不要关心具体在哪个位置跳，我只需要关心当前位置最多能跳的覆盖位置在哪里就行了。
 * 只要覆盖没有到达最后位置就不停扩充最大覆盖位置。
 */
public class C06_JumpGameII {
    public int jump(int[] nums) {
      if (nums==null ||nums.length<=1){
          return 0;
      }
      int count = 0;
      int curMaxDistance = 0;
      int maxDistance = 0;
      for (int i=0; i<nums.length;i++){
          maxDistance = Math.max(maxDistance,i+nums[i]);
          if (maxDistance>=nums.length-1){
              count++;
              return count;
          }
          if (i == curMaxDistance){
              curMaxDistance = maxDistance;
              count++;
          }
      }
      return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 1, 4};
        C06_JumpGameII c06_jumpGameII = new C06_JumpGameII();
        int jump = c06_jumpGameII.jump(nums);
        System.out.println(jump);
    }
}
