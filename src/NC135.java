/**
 * @author dingxudong
 * @create 2021-09-29 11:29
 * @Description
 * 假定你知道某只股票每一天价格的变动。
 * 你最多可以同时持有一只股票。但你最多只能进行两次交易（一次买进和一次卖出记为一次交易。买进和卖出均无手续费）。
 * 请设计一个函数，计算你所能获得的最大收益。
 */
public class NC135 {
    //维护一个时间序列，每个序列四个状态，所以相当于二维动态规划问题;
//    public int maxProfit (int[] prices) {
//        // write code here
//        if (prices.length == 0) return 0;
//        int[][] dp = new int[prices.length][4];
//        dp[0][0] = -prices[0];
//        dp[0][2] = -prices[0];
//        for(int i = 1; i < prices.length; i++){
//            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] - prices[i]);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] + prices[i]);
//        }
//        return dp[prices.length - 1][3];
//    }
    public int maxProfit (int[] prices) {
        if (prices.length == 0) return 0;
        int buy1 = - prices[0];
        int sell1 = 0;
        int buy2 = - prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

}
