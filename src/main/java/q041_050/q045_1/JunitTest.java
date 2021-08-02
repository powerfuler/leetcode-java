package q041_050.q045_1;

import org.junit.Test;
import q041_050.q045_1.code.Solution;

public class JunitTest {
    @Test
    public void test0() {
        int[] nums = new int[]{2, 3, 1, 5, 3, 2, 2, 1, 1};
        int jump = new Solution().jump1(nums);
        System.out.println(jump);
    }
}
