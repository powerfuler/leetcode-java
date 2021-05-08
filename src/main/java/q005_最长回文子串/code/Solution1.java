package q005_最长回文子串.code;

/**
 * 中心扩散法
 * 中心扩散法也很好理解，我们遍历字符串的每一个字符，然后以当前字符为中心往两边扩散，查找最长的回文子串
 * 但忽略了一个问题，回文串的长度不一定都是奇数，也可能是偶数，比如字符串"abba"，如果使用上面的方式判断肯定是不对的。
 * 我们来思考这样一个问题，如果是单个字符，我们可以认为他是回文子串，如果是多个字符，并且他们都是相同的，那么他们也是回文串。
 * 所以对于上面的问题，我们以当前字符为中心往两边扩散的时候，先要判断和他挨着的有没有相同的字符，如果有，则直接跳过，来看下代码
 *
 * o(n^2) 以每个字符为中心计算回文长度
 */
public class Solution1 {

    public String longestPalindrome(String s) {
        //边界条件判断
        if (s.length() < 2)
            return s;
        //start表示最长回文串开始的位置，
        //maxLen表示最长回文串的长度
        int start = 0, maxLen = 0;
        int length = s.length();
        for (int i = 0; i < length; ) {
            //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            // （因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断）
            if (length - i <= maxLen / 2)
                break;
            int left = i, right = i;
            while (right < length - 1 && s.charAt(right + 1) == s.charAt(right))
                ++right; //过滤掉重复的
            //下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            //然后往两边判断，找出回文子串的长度
            while (right < length - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                ++right;
                --left;
            }
            //保留最长的
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        //截取回文子串
        return s.substring(start, start + maxLen);
    }

}
