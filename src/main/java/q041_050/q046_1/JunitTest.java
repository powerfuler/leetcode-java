package q041_050.q046_1;

import org.junit.Test;
import q041_050.q046_1.code.Solution;

import java.util.List;

public class JunitTest {

    @Test
    public void test0() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = new Solution().permute(nums);
        System.out.println(permute);
    }
}
