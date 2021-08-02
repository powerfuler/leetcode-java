package q041_050.q041_1;

import org.junit.Test;
import q041_050.q041_1.code.Solution1;

public class JunitTest {
    @Test
    public void test0() {
        int[] nums = new int[]{3, 4, -1, 1};
        long t4 = System.currentTimeMillis();
        int i = new Solution1().firstMissingPositive(nums);
        long t5 = System.currentTimeMillis();
        System.out.println(i);
    }
}
