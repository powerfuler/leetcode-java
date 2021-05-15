package q011_020.q011_盛最多水的容器;

import org.junit.Test;
import q011_020.q011_盛最多水的容器.code.Solution2;

public class JunitTest {

    @Test
    public void test0() {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution2().maxArea(a));
    }

}
