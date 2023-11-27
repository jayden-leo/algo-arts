package c01_array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * link:https://leetcode.cn/problems/spiral-matrix-ii/description/
 */
public class C05SpiralMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 0;
        int rowIndex;
        int colIndex;
        int count = 1;
        for (int i = 0; i < n / 2; i++) {
            for (colIndex = start; colIndex < n - start - 1; colIndex++) {
                result[start][colIndex] = count++;
            }
            for (rowIndex = start; rowIndex < n - start - 1; rowIndex++) {
                result[rowIndex][colIndex] = count++;
            }
            for (; colIndex > start; colIndex--) {
                result[rowIndex][colIndex] = count++;
            }
            for (; rowIndex > start; rowIndex--) {
                result[rowIndex][colIndex] = count++;
            }
            start++;
        }
        if (n % 2 == 1) {
            result[start][start] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = C05SpiralMatrix.generateMatrix(5);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
