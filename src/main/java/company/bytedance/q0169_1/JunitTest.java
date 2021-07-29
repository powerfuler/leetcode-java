package company.bytedance.q0169_1;

import company.bytedance.q0169_1.code.Solution2;
import org.junit.Test;

public class JunitTest {
    @Test
    public void test0() {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = new Solution2().majorityElement(nums);
        System.out.println(i);
    }
}
