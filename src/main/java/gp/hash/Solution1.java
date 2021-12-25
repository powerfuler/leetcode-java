package gp.hash;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        Set<Character> set = new HashSet<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - i);
            }
            set.remove(s.charAt(i));
        }
        return max;
    }
}