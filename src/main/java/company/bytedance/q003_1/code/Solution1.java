package company.bytedance.q003_1.code;

import java.util.HashMap;

/**
 * Hash+双指针滑动窗口 o(n)
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        // 初始化滑动窗口左右指针为0位置，长度为0
        int left = 0;
        int right = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            // 判断map里面是否已存在字符，并put当前字符
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);
            // 已存在字符，left = index + 1
            if (index != null && index >= left) {
                left = index + 1;
            }
            // 比较长度
            if (right - left + 1 > len) {
                len = right - left + 1;
            }
            // 每次循环右指针往右移动一位
            right++;
        }
        return len;
    }
}
