package q031_040.q031_下一个排列;

import org.junit.Test;
import q031_040.q031_下一个排列.code.Solution2;

public class JunitTest {
    @Test
    public void test0() {
        int[] nums = {1, 2, 3, 8, 5, 7, 6, 4};
        long t1 = System.currentTimeMillis();
        int[] ints = new Solution2().nextPermutation(nums);
        System.out.println(ints);
        long t2 = System.currentTimeMillis();
    }

}
