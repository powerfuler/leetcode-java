package practice.q003_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0, ans = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);

            if (index != null && left <= index) {
                left = index + 1;
            }
            if (right - left + 1 > ans) {
                ans = right - left + 1;
            }
            right++;
        }
        return ans;
    }
}