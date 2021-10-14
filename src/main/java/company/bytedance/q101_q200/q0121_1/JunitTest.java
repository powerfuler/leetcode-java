package company.bytedance.q101_q200.q0121_1;

import company.bytedance.q101_q200.q0121_1.code.Solution1;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test0() {
        int[] prices = new int[]{4, 1, 8, 4, 5};
        new Solution1().maxProfit(prices);
    }
}
