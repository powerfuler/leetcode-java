package q061_070.q070_1.code;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 */
public class Solution1 {
    int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }

    public static void main(String[] args) {
        int i = new Solution1().climbStairs(6);
        System.out.println(i);
    }
}