package q061_070.q062_1.code;

import java.util.Arrays;

/**
 *动态规划
 *
 * 我们令 dp[i][j] 是到达 i, j 最多路径
 * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(m * n)
 * 优化：因为我们每次只需要 dp[i-1][j],dp[i][j-1]
 * 所以我们只要记录这两个数，直接看代码吧！
 */
public class Solution1 {
    public int uniquePaths1(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().uniquePaths2(3, 7));
    }
}