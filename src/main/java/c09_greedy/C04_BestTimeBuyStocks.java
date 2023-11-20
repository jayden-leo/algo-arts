package c09_greedy;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 * link: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class C04_BestTimeBuyStocks {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i=1;i<prices.length;i++){
            int temp = prices[i]-prices[i-1];
            if (temp >0){
                result+=temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        C04_BestTimeBuyStocks c04_bestTimeBuyStocks = new C04_BestTimeBuyStocks();
        int result = c04_bestTimeBuyStocks.maxProfit(prices);
        System.out.println(result);
    }
}
