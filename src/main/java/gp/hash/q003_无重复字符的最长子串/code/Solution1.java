package gp.hash.q003_无重复字符的最长子串.code;

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
            // 判断map里面是否已存在字符
            Integer index = map.get(s.charAt(right));
            // put当前字符
            map.put(s.charAt(right), right);
            if (index != null && index >= left) {
                // 当前字符已存在map,左指针往后移一位
                left = index + 1;
            }
            if (right - left + 1 > len) {
                // 左指针未动，长度+1
                len = right - left + 1;
            }
            // 每次循环右指针往右移动一位
            right++;
        }
        return len;
    }


    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if(n == 0) {    //如果为空字符串，直接返回0
                return 0;
            }
            //因为本题中字符串只含有英文字母，符号和数字，所以可以使用数组来代替哈希表，提高效率。
            int[] num = new int[128];
            int res = 0;
            //left: 左指针    right: 右指针
            int left = 0, right = 0;
            //将字符串转换为一个char数组,写起来方便
            char[] cs = s.toCharArray();

            while(right < n) {
                //每次循环都将右侧指针向前移动一位，并将右侧指针所指向的字符的数量增加1
                //(byte) cs[right]表示将字符cs[right]转换为其所对应的ASCII码，在0~127之间，
                //恰好可以使用byte表示
                num[(byte) cs[right]]++;
                //如果此时右侧指针所对应的字符的数量超过1，表示已经有了重复字符，将左指针右移
                while(num[(byte) cs[right]] > 1) {
                    num[(byte) cs[left++]]--;
                }
                //更新结果，取之前的结果与当前窗口长度的最大值
                res = Math.max(res, right - left + 1);
                //右指针右移
                right++;
            }
            return res;
        }
    }
}
