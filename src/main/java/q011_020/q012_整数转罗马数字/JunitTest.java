package q011_020.q012_整数转罗马数字;

import org.junit.Assert;
import org.junit.Test;
import q011_020.q012_整数转罗马数字.code.Solution1;

public class JunitTest {

        @Test
        public void test1() {
            Solution1 solution = new Solution1();
            Assert.assertEquals("III", solution.intToRoman(3));
        }

        @Test
        public void test2() {
            Solution1 solution = new Solution1();
            Assert.assertEquals("IV", solution.intToRoman(4));
        }

        @Test
        public void test3() {
            Solution1 solution = new Solution1();
            Assert.assertEquals("IX", solution.intToRoman(9));
        }

        @Test
        public void test4() {
            Solution1 solution = new Solution1();
            Assert.assertEquals("LVIII", solution.intToRoman(58));
        }

        @Test
        public void test5() {
            Solution1 solution = new Solution1();
            Assert.assertEquals("MMCMDXCVCICIV", solution.intToRoman(3894));
        }

}
