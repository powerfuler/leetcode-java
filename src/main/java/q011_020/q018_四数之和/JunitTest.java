package q011_020.q018_四数之和;

import org.junit.Test;
import q011_020.q018_四数之和.code.Solution1;

public class JunitTest {

    @Test
    public void test0() {
        int[] a = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(new Solution1().fourSum(a, 0));
    }
}
