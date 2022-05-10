package practice.q0121_买卖股票的最佳时机;

/**
 * 遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润），
 * 所有下降交易日都不买卖（永不亏钱）。
 * 设 tmp 为第 i-1 日买入与第 i 日卖出赚取的利润，即 tmp = prices[i] - prices[i - 1] ；
 * 当该天利润为正 tmp > 0，则将利润加入总利润 profit；当利润为 0 或为负，则直接跳过；
 * 遍历完成后，返回总利润 profit。
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int money = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                money += tmp;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 5, 4, 8, 6, 6, 4};
        System.out.println(new Solution2().maxProfit(a));
    }
}
