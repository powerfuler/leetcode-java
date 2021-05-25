package q021_030.q022_括号生成;

import org.junit.Test;
import q021_030.q022_括号生成.code.Solution1;

import java.util.List;

public class JunitTest {
    @Test
    public void test0() {
        long t4 = System.currentTimeMillis();
        List<String> strings = new Solution1().generateParenthesis(2);
        long t5 = System.currentTimeMillis();
        System.out.println(strings);
    }
}
