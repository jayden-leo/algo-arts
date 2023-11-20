package c09_greedy;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * link: https://leetcode.cn/problems/candy/
 */
public class C09_handOutCandy {
    public int candy(int[] ratings) {
        if (ratings==null || ratings.length==0){
            return 0;
        }
        if (ratings.length==1){
            return 1;
        }
        int sum = 0;
        int[] candyArr = new int[ratings.length];
        for(int i=0; i <ratings.length;i++){
            candyArr[i] = 1;
        }
        // 从左到右
        for(int i=1; i <ratings.length;i++){
            if (ratings[i]>ratings[i-1]){
                candyArr[i]+=candyArr[i-1];
            }
        }
        // 从右到左
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]&&candyArr[i]<=candyArr[i+1]){
                candyArr[i] = candyArr[i+1]+1;
            }
        }
        // 累计
        for (int i=0;i<candyArr.length;i++){
            sum += candyArr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1};
        C09_handOutCandy c09_handOutCandy = new C09_handOutCandy();
        int candy = c09_handOutCandy.candy(ratings);
        System.out.println(candy);
    }
}
