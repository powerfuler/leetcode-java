package q061_070.q062_1.code;

/**
 * 动态规划 dp[i][j]是到达i, j的最多路径 dp[i][j] = dp[i-1][j] + dp[i][j-1] o(m*n)
 *
 * 我们令 dp[i][j] 是到达 i, j 最多路径
 * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(m * n)
 * 优化：因为我们每次只需要 dp[i-1][j],dp[i][j-1]
 * 所以我们只要记录这两个数，直接看代码吧！
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(13, 97));
    }
}
