package company.bytedance.q0128_1;

import company.bytedance.q0128_1.code.Solution1;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        long t4 = System.currentTimeMillis();
        int i = new Solution1().longestConsecutive(nums);
        long t5 = System.currentTimeMillis();
        System.out.println(i);
    }
}
