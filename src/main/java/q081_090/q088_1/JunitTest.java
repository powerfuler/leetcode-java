package q081_090.q088_1;

import q081_090.q088_1.code.Solution3;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        long t4 = System.currentTimeMillis();
        new Solution3().merge(nums1, m, nums2, n);
        long t5 = System.currentTimeMillis();
        System.out.println(nums1.toString());
    }
}
