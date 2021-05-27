package q021_030.q028_实现strStr.code;

/**
 * 朴素解法
 * 直观的解法的是：
 * 枚举原串 ss 中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配：
 *
 * 匹配成功：返回本次匹配的原串「发起点」。
 * 匹配失败：枚举原串的下一个「发起点」，重新尝试匹配
 * 时间复杂度：n 为原串的长度，m 为匹配串的长度。其中枚举的复杂度为 O(n−m)，构造和比较字符串的复杂度为 O(m)。整体复杂度为 O((n−m)∗m)。
 *
 * 空间复杂度：O(1)。
 *
 */
public class Solution1 {
    public int strStr(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) {
                return i;
            }
        }
        return -1;
    }
}
