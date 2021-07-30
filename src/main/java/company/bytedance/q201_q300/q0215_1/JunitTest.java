package company.bytedance.q201_q300.q0215_1;

import company.bytedance.q201_q300.q0215_1.code.Solution2;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums1 = {1, 2, 3, 1, 5, 6};
        long t4 = System.currentTimeMillis();
        int kthLargest = new Solution2().findKthLargest(nums1, 2);
        long t5 = System.currentTimeMillis();
        System.out.println(kthLargest);
    }
}
