package c09_greedy;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * link: https://leetcode.cn/problems/non-overlapping-intervals/
 */
public class C15_MergeInterval {
    public int[][] merge(int[][] intervals) {
        int[][] result = {{},{}};
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        C15_MergeInterval c15_mergeInterval = new C15_MergeInterval();
        int[][] merge = c15_mergeInterval.merge(intervals);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println(" ");
        }
    }
}
