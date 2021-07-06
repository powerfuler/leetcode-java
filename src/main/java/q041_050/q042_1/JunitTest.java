package q041_050.q042_1;

import org.junit.Test;
import q041_050.q042_1.code.Solution;

public class JunitTest {

    @Test
    public void test0() {
        long t4 = System.currentTimeMillis();
        int trap = new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        long t5 = System.currentTimeMillis();
        System.out.println(trap);
    }
}
