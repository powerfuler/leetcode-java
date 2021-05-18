package q011_020.q013_罗马数字转整数;

import org.junit.Assert;
import org.junit.Test;
import q011_020.q013_罗马数字转整数.code.Solution1;

public class JunitTest {

    @Test
    public void test1() {
        Solution1 solution = new Solution1();
        Assert.assertEquals(3, solution.romanToInt("III"));
    }

    @Test
    public void test2() {
        Solution1 solution = new Solution1();
        Assert.assertEquals(4, solution.romanToInt("IV"));
    }

    @Test
    public void test3() {
        Solution1 solution = new Solution1();
        Assert.assertEquals(9, solution.romanToInt("IX"));
    }

    @Test
    public void test4() {
        Solution1 solution = new Solution1();
        Assert.assertEquals(58, solution.romanToInt("LVIII"));
    }

    @Test
    public void test5() {
        Solution1 solution = new Solution1();
        Assert.assertEquals(3688, solution.romanToInt("MMCMDXCVCICIV"));
    }

}
