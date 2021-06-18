package company.bytedance.q015_1;

import org.junit.Test;
import q011_020.q015_三数之和.code.Solution1;

import java.util.List;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums = {-1, 0, 1, 2, -1, -4, 4, -3, -5, 8, 9, 10, -7, 8,1,1,1,2,2,3,3,3,4,4,4,5,5,6,6,7,7,7,8,8,9,9,0,9,8,8,8};
        long t4 = System.currentTimeMillis();
        List<List<Integer>> lists = new Solution1().threeSum(nums);
        long t5 = System.currentTimeMillis();

        System.out.println("time cost is " + (t5 - t4) + "ms; listsSize:" +lists.size() +" list :" + lists);
    }
}
