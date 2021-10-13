package company.bytedance.q101_q200.q0118_1;

import company.bytedance.q101_q200.q0118_1.code.Solution1;
import org.junit.Test;

import java.util.List;

public class JunitTest {

    @Test
    public void test0() {
        List<List<Integer>> generate = new Solution1().generate(10);
        System.out.println(generate);
    }
}
