package q011_020.q016_最接近的三数之和;

import org.junit.Test;
import q011_020.q016_最接近的三数之和.code.Solution1;

public class JunitTest {

    @Test
    public void test0() {
        int[] a = new int[]{-3, -2, -5, 3, -4};
        System.out.println(new Solution1().threeSumClosest(a, -1));
    }
}
