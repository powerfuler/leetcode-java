package q031_040.q032_最长有效括号;

import org.junit.Test;
import q031_040.q032_最长有效括号.code.Solution2;

public class JunitTest {
    @Test
    public void test0() {
        long t4 = System.currentTimeMillis();
        System.out.println(new Solution2().longestValidParentheses(")(()())"));
        long t5 = System.currentTimeMillis();
    }
}
