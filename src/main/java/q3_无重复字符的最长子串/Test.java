package q3_无重复字符的最长子串;

/*
*/

import q3_无重复字符的最长子串.code.Solution1;

public class Test {
    public static void main(String[] args) {
        String str = "abcabcdbb";
        long t1 = System.currentTimeMillis();
        int len = new Solution1().lengthOfLongestSubstring(str);
        long t2 = System.currentTimeMillis();
        System.out.println("time cost is " + (t2 - t1) + " ms;");
        System.out.println("子串:" + len);
    }

}
