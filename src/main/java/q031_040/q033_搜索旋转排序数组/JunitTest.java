package q031_040.q033_搜索旋转排序数组;

import org.junit.Test;
import q031_040.q033_搜索旋转排序数组.code.Solution1;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        long t4 = System.currentTimeMillis();
        int search = new Solution1().search(nums, 3);
        long t5 = System.currentTimeMillis();
        System.out.println(search);

    }
}
