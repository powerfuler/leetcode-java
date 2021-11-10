package company.bytedance.q101_q200.q0188_2.code;

class Solution {
    public int maxProfit(int k, int[] prices) {
        /*
        dp[i][0][k]: 可选择前i支股票，当前无股票且交易了k次的最大利润
        dp[i][1][k]: 可选择前i支股票，当前有股票且交易了k次的最大利润
        */
        int n = prices.length;
        if (n < 2) return 0;
        int[][][] dp = new int[n][2][k + 1];
        int INF = -0xfffff;
        for (int i = 1; i <= k; i++) {
            dp[0][0][i] = dp[0][1][i] = INF;
        }
        dp[0][0][0] = 0; dp[0][1][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
            }
            for (int j = 0; j <= k; j++) {
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(dp[n - 1][0][i], ans); //最大利润必定不持股
        }
        return ans;
    }
}