package company.bytedance.q101_q200.q0151_1.code;

import java.util.Arrays;
import java.util.Collections;

/**
 * 使用Java内置方法
 * 1、先切分
 * 2、逆序
 * 3、输出
 */
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        String stringBuilder = new Solution().reverseWords(s);
        System.out.println(stringBuilder);
    }
}