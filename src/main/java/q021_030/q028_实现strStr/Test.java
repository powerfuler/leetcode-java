package q021_030.q028_实现strStr;

/*
 */

import q021_030.q028_实现strStr.code.Solution2;

public class Test {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        String str1 = "bacbababadababacambabacaddababacasdsd";
        String str2 = "ababaca";
        System.out.println(new Solution2().strStr(haystack, needle));

        // api调用
        int i = haystack.indexOf(needle);
        System.out.println(i);
    }
}
