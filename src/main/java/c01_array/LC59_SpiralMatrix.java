package c01_array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * link:https://leetcode.cn/problems/spiral-matrix-ii/description/
 */
public class LC59_SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 0;
        int count = 1;
        int x=0, y = 0;
        for (int i = 1; i <= n / 2; i++) {
            for (y = start; y < n - i; y++) {
                result[start][y] = count++;
            }
            for (x = start;x<n-i;x++){
                result[x][y] = count++;
            }
            for (;y>start;y--){
                result[x][y] = count++;
            }
            for (;x>start;x--){
                result[x][y] = count++;
            }
            start++;
        }
        if (n%2==1){
            result[start][start] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        LC59_SpiralMatrix c05SpiralMatrix = new LC59_SpiralMatrix();
        int[][] ints = c05SpiralMatrix.generateMatrix(3);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
