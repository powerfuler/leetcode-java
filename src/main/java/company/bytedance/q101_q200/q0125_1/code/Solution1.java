package company.bytedance.q101_q200.q0125_1.code;

/**
 *
 */
public class Solution1 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            // 确定指定的字符是否为字母或数字
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}