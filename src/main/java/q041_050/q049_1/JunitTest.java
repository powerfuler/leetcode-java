package q041_050.q049_1;

import org.junit.Test;
import q041_050.q049_1.code.Solution;

import java.util.List;

public class JunitTest {
    @Test
    public void test0() {
        String[] nums = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(nums);
        System.out.println(lists);
    }
}
