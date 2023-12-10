package c01_array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * link:https://leetcode.cn/problems/spiral-matrix-ii/description/
 */
public class C05SpiralMatrix {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start = 0;
        int row = 0;
        int col = 0;
        int count = 1;
        for (int i = 1; i <= n / 2; i++) {
            for (col = start; col < n - i; col++) {
                res[row][col] = count++;
            }
            for (row = start; row < n - i; row++) {
                res[row][col] = count++;
            }
            for (; col > start; col--) {
                res[row][col] = count++;
            }
            for (; row > start; row--) {
                res[row][col] = count++;
            }
            start++;
            row=start;
        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] result = new C05SpiralMatrix().generateMatrix(4);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
