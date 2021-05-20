package q011_020.q016_1;

import org.junit.Test;
import q011_020.q016_1.code.Solution1;

public class JunitTest {

    @Test
    public void test0() {
        int[] a = new int[]{-3, -2, -5, 3, -4};
        System.out.println(new Solution1().threeSumClosest(a, -1));
    }
}
