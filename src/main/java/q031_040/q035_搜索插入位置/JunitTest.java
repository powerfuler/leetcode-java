package q031_040.q035_搜索插入位置;

import org.junit.Test;
import q031_040.q035_搜索插入位置.code.Solution1;

public class JunitTest {
    @Test
    public void test0() {
        int[] nums = {5, 7, 7, 8, 9, 10};
        long t4 = System.currentTimeMillis();
        int i = new Solution1().searchInsert(nums, 8);
        long t5 = System.currentTimeMillis();
        System.out.println(i);

    }
}
