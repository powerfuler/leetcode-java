package gp.DP.L1143;

/**
 * 动态规划 dp[i + 1][j + 1] = Math.max(dp[i+1][j], dp[i][j+1]) o(m*n)
 *
 * 若题目为最长公共子串，则在c1,c2不相等时不做处理（赋值0），在遍历过程中记录最大值即可
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
