package company.bytedance.q101_q200.q0125_1;

import company.bytedance.q101_q200.q0125_1.code.Solution1;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test0() {
        String str = "A man, a plan, a canal: Panama";
        boolean palindrome = new Solution1().isPalindrome(str);
        System.out.println(palindrome);
    }
}
