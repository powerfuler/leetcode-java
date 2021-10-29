package company.bytedance.q101_q200.q0139_1.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划 写法1
 * 具体做法是:
 * 用两个指针i和j, 对于字符串s中[i:j]范围内的子串subs, 都去判断一下dp[i]是不是true以及subs在不在数组wordDict中。
 *
 * 最后返回dp[len]。
 *
 * 时间复杂度: O(N^2), 其中N是字符串s的长度。
 */
public class Solution3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int max_length = 0;
        for (String temp : wordDict) {
            max_length = temp.length() > max_length ? temp.length() : max_length;
        }
        //  memo[i] 表示 s 中以 i- 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && max_length >= i - j; j--) {
                String substring = s.substring(j, i);
                if (memo[j] && wordDict.contains(substring)) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("og");
//        wordDict.add("sand");
        wordDict.add("and");
//        wordDict.add("cat");

        boolean b = new Solution3().wordBreak(s, wordDict);
        System.out.println(b);
    }
}