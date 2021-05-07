package q7_整数反转;

import org.junit.Test;
import q7_整数反转.code.Solution1;
import q7_整数反转.code.Solution2;

public class JunitTest {
    @Test
    public void test0() {
        long t4 = System.currentTimeMillis();
//        new Solution2().addTwoNumbers(l1, l2);
        long t5 = System.currentTimeMillis();
        System.out.println(new Solution1().reverse(-1234));
        System.out.println(new Solution2().reverse(-1234));
//        CommonUtil.print(listNode);
    }

}
