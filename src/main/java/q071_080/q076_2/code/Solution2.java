package q071_080.q076_2.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 *
 * 用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，当这个窗口包含的元素满足条件，
 * 即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。
 * 使用map存储需要匹配的字符
 */
public class Solution2 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> needMap = new HashMap(16);
        for (int i = 0; i < t.length(); i++) {
            Integer integer = needMap.get(t.charAt(i)) != null ? needMap.get(t.charAt(i)) + 1 : 1;
            needMap.put(t.charAt(i), integer);
        }
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (r < s.length()) {
            char cr = s.charAt(r);
            if (needMap.get(cr) != null && needMap.get(cr) > 0) {
                count--;
            } else {
                Integer integer = needMap.get(cr) != null ? needMap.get(cr) : 0;
                needMap.put(cr, integer);
            }
            Integer integer = needMap.get(cr);
            needMap.put(cr, integer - 1);
            if (count == 0) {
                while (l < r && needMap.get(s.charAt(l)) < 0) {
                    integer = needMap.get(s.charAt(l)) != null ? needMap.get(s.charAt(l)) + 1 : 0;
                    needMap.put(s.charAt(l), integer);
                    l++;
                }
                if (r - l + 1 < size) {
                    size = r - l + 1;
                    start = l;
                }
                integer = needMap.get(s.charAt(l)) != null ? needMap.get(s.charAt(l)) + 1 : 0;
                needMap.put(s.charAt(l), integer);
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String minWindow = new Solution2().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(minWindow);
    }
}