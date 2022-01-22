/**
 * @author dingxudong
 * @create 2021-09-29 10:54
 * @Description
 * 假定你知道 n 天内的某只股票每一天价格的变动。
 * 你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。
 * 请设计一个函数，计算你所能获得的最大收益。
 *
 * 输入一个数组，数组长度为 n ，数组中每一个元素为 arri 代表当天股票的价格
 */
public class NC134 {
    public int maxProfit (int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]){
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
