package q091_100.q097_1.code;

/**
 *
 * 我们使用 dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符是否能构成 s3 的前 i+j 个字符。
 * 首先，dp[0][0] 一定是 True
 *
 * 1、初始化 s1,s2,s3 的长度分别为 len1,len2,len3
 * 2、若 len1+len2!=len3，表示一定不能构成交错字符串，返回 False
 * 3、初始化 dp 为 (len1+1)∗(len2+1) 的 False 数组。
 * 4、初始化第一列 dp[i][0]，遍历第一列，遍历区间 [1,len1+1)：
 *  4.1、dp[i][0]=dp[i-1][0] and s1[i-1]==s3[i-1]。表示 s1 的前 i 位是否能构成 s3 的前 i 位。
 *       因此需要满足的条件为，前 i-1 位可以构成 s3 的前 i-1 位且 s1 的第 i 位（s1[i−1]）等于 s3 的第 i 位（s3[i−1]）
 * 5、初始化第一行 dp[0][j]，遍历第一行，遍历区间 [1,len2+1)：
 *  5.1、dp[0][i]=dp[0][i-1] and s2[i-1]==s3[i-1]。表示 s2 的前 i 位是否能构成 s3 的前 i 位。
 *       因此需要满足的条件为，前 i−1 位可以构成 s3 的前 i−1 位且 s2 的第 i 位（s2[i−1]）等于 s3 的第 i 位（s3[i−1]）
 * 6、遍历 dp 数组，每一行 i，遍历区间 [1,len1+1)：每一列 j，遍历区间 [1,len2+1)：
 *   6.1、dp[i][j]=(dp[i][j-1] and s2[j-1]==s3[i+j-1]) or (dp[i-1][j] ands1[i-1]==s3[i+j-1])$$ 。
 *    解释：$s1$ 前$i$ 位和 $s2$ 的前 $j$ 位能否组成 $s3$ 的前 $i+j$ 位取决于两种情况：
 *   6.2、s1 的前 i 个字符和 s2 的前j−1 个字符能否构成 s3 的前 i+j−1 位，且 s2 的第 j 位（s2[j−1]）是否等于s3 的第 i+j 位（s3[i+j−1]）。
 * 7、返回 dp[len1][len2]
 *
 * 复杂度分析
 *
 * 时间复杂度：O(m∗n)，m 为 s1s1 的长度，n 为 s2s2 的长度。
 * 空间复杂度：O(m∗n)
 *
 */
public class Solution1 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < l2 + 1; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "aabccd", s2 = "dbbcae", s3 = "aadbbcbcacdd";
        boolean interleave = new Solution1().isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }
}