package company.bytedance.q101_q200.q0120_1.code;

import java.util.List;

/**
 *
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];

        List<Integer> lastRow = triangle.get(n - 1);

        for (int i = 0; i < n; ++i) {
            dp[i] = lastRow.get(i);
        }

        for (int i = n - 2; i >= 0; --i) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < i + 1; ++j) {
                // i + 1 == row.size()
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }

        return dp[0];
    }
}