package q006_Z字形变换;

import org.junit.Test;
import q006_Z字形变换.code.Solution1;

public class JunitTest {

    @Test
    public void test0() {
        long t4 = System.currentTimeMillis();
        System.out.println(new Solution1().convert("LEETCODEISHIRING", 5));
        long t5 = System.currentTimeMillis();
//        CommonUtil.print(listNode);
    }

}
