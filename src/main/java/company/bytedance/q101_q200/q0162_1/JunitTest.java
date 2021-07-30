package company.bytedance.q101_q200.q0162_1;

import company.bytedance.q101_q200.q0162_1.code.Solution1;
import org.junit.Test;

public class JunitTest {
    @Test
    public void test0() {
        int[] nums1 = {1,2,3,4,5,6};
        long t4 = System.currentTimeMillis();
        int peakElement = new Solution1().findPeakElement(nums1);
        long t5 = System.currentTimeMillis();
        System.out.println(peakElement);
    }
}
