package q5_最长回文子串.code;

/**
 * 动态规划 o(n^2)
 * 转移方程：字符串两边界值相等并且子字符串是回文字符串则该字符串是回文字符串
 * dp数组含义：字符串s从i到j的索引子字符串是否是回文字符串
 *
 *
 * 定义二维数组dp[length][length]，如果dp[left][right]为true，则表示字符串从left到right是回文子串，如果dp[left][right]为false，则表示字符串从left到right不是回文子串。
 * 如果dp[left+1][right-1]为true，我们判断s.charAt(left)和s.charAt(right)是否相等，如果相等，那么dp[left][right]肯定也是回文子串，否则dp[left][right]一定不是回文子串。
 * 所以我们可以找出递推公式
 *  dp[left][right]=s.charAt(left)==s.charAt(right)&&dp[left+1][right-1]
 * 有了递推公式，还要确定边界条件：
 * 如果s.charAt(left)！=s.charAt(right)，那么字符串从left到right是不可能构成子串的，直接跳过即可。
 * 如果s.charAt(left)==s.charAt(right)，字符串从left到right能不能构成回文子串还需要进一步判断
 * 如果left==right，也就是说只有一个字符，我们认为他是回文子串。即dp[left][right]=true（left==right）
 * 如果right-left<=2，类似于"aa"，或者"aba"，我们认为他是回文子串。即dp[left][right]=true（right-left<=2）
 * 如果right-left>2，我们只需要判断dp[left+1][right-1]是否是回文子串，才能确定dp[left][right]是否为true还是false。即dp[left][right]=dp[left+1][right-1]
 * 有了递推公式和边界条件
 *
 */
public class Solution2 {
    public static String longestPalindrome(String s) {
        //边界条件判断
        if (s.length() < 2)
            return s;
        //start表示最长回文串开始的位置，
        //maxLen表示最长回文串的长度
        int start = 0, maxLen = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                //如果两种字符不相同，肯定不能构成回文子串
                if (s.charAt(left) != s.charAt(right))
                    continue;

                //下面是s.charAt(left)和s.charAt(right)两个
                //字符相同情况下的判断
                //如果只有一个字符，肯定是回文子串
                if (right == left) {
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    //类似于"aa"和"aba"，也是回文子串
                    dp[left][right] = true;
                } else {
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[left][right] = dp[left + 1][right - 1];
                }
                //如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        //截取最长的回文子串
        return s.substring(start, start + maxLen);
    }

}
