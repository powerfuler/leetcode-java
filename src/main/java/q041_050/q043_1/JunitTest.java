package q041_050.q043_1;

import org.junit.Test;
import q041_050.q043_1.code.Solution1;

public class JunitTest {
    @Test
    public void test0() {
        String num1 = "802", num2 = "89";
        long t4 = System.currentTimeMillis();
        String multiply = new Solution1().multiply(num1, num2);
        long t5 = System.currentTimeMillis();
        System.out.println(multiply);
    }
}
