package q031_040.q034_在排序数组中查找元素的第一个和最后一个位置;

import org.junit.Test;
import q031_040.q034_在排序数组中查找元素的第一个和最后一个位置.code.Solution2;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        long t4 = System.currentTimeMillis();
        int[] ints = new Solution2().searchRange(nums, 8);
        long t5 = System.currentTimeMillis();
        System.out.println(ints);
    }
}
