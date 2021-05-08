package q005_最长回文子串;

import org.junit.Test;
import q005_最长回文子串.code.Solution1;
import q005_最长回文子串.code.Solution2;

public class JunitTest {

    @Test
    public void test0() {
        Solution1 solution = new Solution1();
        Solution2 solution2 = new Solution2();
//        System.out.println(solution.longestPalindrome("abcba"));
//        System.out.println(solution2.longestPalindrome("aba"));
//        System.out.println(solution2.longestPalindrome("abcbad"));
        System.out.println(solution2.longestPalindrome("caeabbbfbbbaea"));

        long t4 = System.currentTimeMillis();
//        new Solution2().addTwoNumbers(l1, l2);
        long t5 = System.currentTimeMillis();

    }

}
