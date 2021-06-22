package company.bytedance.q003_1.code;

/**
 * Hash+双指针滑动窗口 o(n)
 */
public class Solution11 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //如果为空字符串，直接返回0
        if (n == 0) {
            return 0;
        }
        //因为本题中字符串只含有英文字母，符号和数字，所以可以使用数组来代替哈希表，提高效率。
        int[] num = new int[128];
        int res = 0;
        //left: 左指针    right: 右指针
        int left = 0, right = 0;
        //将字符串转换为一个char数组,写起来方便
        char[] cs = s.toCharArray();

        while (right < n) {
            //每次循环都将右侧指针向前移动一位，并将右侧指针所指向的字符的数量增加1
            //(byte) cs[right]表示将字符cs[right]转换为其所对应的ASCII码，在0~127之间，
            //恰好可以使用byte表示
            num[(byte) cs[right]]++;
            //如果此时右侧指针所对应的字符的数量超过1，表示已经有了重复字符，将左指针右移
            while (num[(byte) cs[right]] > 1) {
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
