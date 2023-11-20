package c09_greedy;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * 示例 1:
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * link: https://leetcode.cn/problems/non-overlapping-intervals/
 */
public class C13_NoOverlappingArea {
    public int eraseOverlapIntervals(int[][] intervals) {

        return 0;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        C13_NoOverlappingArea c13_noOverlappingArea = new C13_NoOverlappingArea();
        int result = c13_noOverlappingArea.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }
}
