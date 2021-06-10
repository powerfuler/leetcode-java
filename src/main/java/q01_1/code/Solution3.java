package q01_1.code;

/**
 * 我们可以实现一个 nextString 方法，传入一个字符串 s，返回该字符串对应的外观数列。
 * 具体的实现，我们只需要统计字符串 s 中每一段连续出现的字符的类型和出现次数即可。
 *
 */
public class Solution3 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = nextString(s);
        }
        return s;
    }
    String nextString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        char[] cs = s.toCharArray();
        char c = cs[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            char cur = cs[i];
            if (cur == c) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(c);

                c = cur;
                cnt = 1;
            }
        }
        sb.append(cnt);
        sb.append(c);
        return sb.toString();
    }
}