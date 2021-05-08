package q010_正则表达式匹配;

import org.junit.Test;
import q010_正则表达式匹配.code.Solution1;

public class JunitTest {

    @Test
    public void test0() {

        long t4 = System.currentTimeMillis();
//        new Solution2().addTwoNumbers(l1, l2);
        long t5 = System.currentTimeMillis();

        System.out.println(new Solution1().isMatch("aaa", "a*a"));
    }

}
