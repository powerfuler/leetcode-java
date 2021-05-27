package q1_2;

/*
 */

import q1_2.code.Solution2;

public class Test {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        String str1 = "bacbababadababacambabacaddababacasdsd";
        String str2 = "ababaca";
        System.out.println(new Solution2().strStr(haystack, needle));
    }
}
