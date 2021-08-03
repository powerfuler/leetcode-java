package q041_050.q047_1;

import org.junit.Test;
import q041_050.q047_1.code.Solution1;

import java.util.List;

public class JunitTest {
    @Test
    public void test0() {
        int[] nums = new int[]{1, 2,1};
        List<List<Integer>> permute = new Solution1().permuteUnique(nums);
        System.out.println(permute);
    }
}
