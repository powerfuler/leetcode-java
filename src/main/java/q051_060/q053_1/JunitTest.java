package q051_060.q053_1;

import org.junit.Test;
import q051_060.q053_1.code.Solution1;

public class JunitTest {

    @Test
    public void test0() {
        System.out.println(new Solution1().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
