package company.bytedance.q0215_1;

import company.bytedance.q0215_1.code.Solution1;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums1 = {1, 2, 3, 1, 5, 6};
        long t4 = System.currentTimeMillis();
        int kthLargest = new Solution1().findKthLargest(nums1, 2);
        long t5 = System.currentTimeMillis();
        System.out.println(kthLargest);
    }
}
