package q071_080.q076_2.code;

/**
 * 滑动窗口
 *
 * 用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，当这个窗口包含的元素满足条件，
 * 即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。
 *
 * 根据字符ASCII码 使用常量数组记录每个字符参数需要的个数
 * 0-9 48-57
 * A-Z 65-90
 * a-z 97-122
 */
public class Solution1 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        // 记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // left是当前左边界，right是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int left = 0, right = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        // 遍历所有字符
        while (right < s.length()) {
            char c = s.charAt(right);
            // 碰见需要字符c，需求的字符个数-1
            if (need[c] > 0) {
                count--;
            }
            // 把右边的字符加入窗口
            need[c]--;
            //窗口中已经包含所有字符， s.charAt(left) <0 表示该字符冗余的个数
            if (count == 0) {
                while (left < right && need[s.charAt(left)] < 0) {
                    // 释放左边移动出窗口的字符，指针右移
                    need[s.charAt(left)]++;
                    left++;
                }
                // 不能右移时候挑战最小窗口大小，更新最小窗口开始的start，记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                // l 向右移动后窗口肯定不能满足了 重新开始循环，继续寻找符合条件的
                need[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String minWindow = new Solution1().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(minWindow);
    }
}