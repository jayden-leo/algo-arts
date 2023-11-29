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
        int[][] res = new int[n][n];
        int start = 0;
        int count = 1;
        int x = 0;
        int y;
        for (int i = 1; i <= n / 2; i++) { // 一共要循环n/2次
            for (y = start; y < n - i; y++) {
                res[x][y] = count++;
            }
            for (; x < n - i; x++) {
                res[x][y] = count++;
            }
            for (; y > start; y--) {
                res[x][y] = count++;
            }
            for (; x > start; x--) {
                res[x][y] = count++;
            }
            start+=1;
            x = start;
        }
        if (n % 2 == 1) { // 如果是奇数，中心还有一个数要填充
            res[start][start] = count;
        }
        return res;
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
