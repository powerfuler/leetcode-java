package company.bytedance.q101_q200.q0120_1;

import company.bytedance.q101_q200.q0120_1.code.Solution1;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JunitTest {

    @Test
    public void test0() {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> t0 = new ArrayList<>();
        t0.add(2);
        triangle.add(t0);
        List<Integer> t1 = new ArrayList<>();
        t1.add(3);
        t1.add(4);
        triangle.add(t1);
        List<Integer> t2 = new ArrayList<>();
        t2.add(6);
        t2.add(5);
        t2.add(7);
        triangle.add(t2);
        List<Integer> t3 = new ArrayList<>();
        t3.add(4);
        t3.add(1);
        t3.add(8);
        t3.add(3);
        triangle.add(t3);

        int total = new Solution1().minimumTotal(triangle);
        System.out.println(total);
    }
}
