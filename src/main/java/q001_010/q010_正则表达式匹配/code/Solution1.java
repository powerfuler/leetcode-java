package q001_010.q010_正则表达式匹配.code;

/**
 * 回溯法 对于*字符，可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即 pattern[0]。
 * 如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 * 题目大意：
 * 实现一个正则表达式匹配算法，.匹配任意一个字符，*匹配0个或者多个前导字符
 */
public class Solution1 {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()){
            return text.isEmpty();
        }
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isMatch("aaa", "a*a"));
    }
}
