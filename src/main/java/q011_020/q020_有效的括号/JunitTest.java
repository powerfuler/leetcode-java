package q011_020.q020_有效的括号;

import org.junit.Test;
import q011_020.q020_有效的括号.code.Solution2;

public class JunitTest {

    @Test
    public void test0() {

        long t4 = System.currentTimeMillis();
//        new Solution2().addTwoNumbers(l1, l2);
        System.out.println(new Solution2().isValid("([)"));
        long t5 = System.currentTimeMillis();

//        CommonUtil.print(listNode);
    }

}
