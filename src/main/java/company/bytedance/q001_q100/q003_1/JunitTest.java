package company.bytedance.q001_q100.q003_1;

import org.junit.Test;
import gp.hash.q003_无重复字符的最长子串.code.Solution1;
import gp.hash.q003_无重复字符的最长子串.code.Solution2;

public class JunitTest {

    @Test
    public void test0() {
        String str = "abcabqqweqrqweqweqweqweqwqrweqwwwwwwwwwwwweeeeeeeeeeeeeeeeeeeeeeeeeqwreteyrtyrtyrtyrtyrtyrtytiyuiyuiyitretrypoiuytrekjhgfds;lkjhgfdsmnbvcxzcdbb";
        long t1 = System.currentTimeMillis();
        int len = new Solution2().lengthOfLongestSubstring(str);
        long t2 = System.currentTimeMillis();
        System.out.println("time cost is " + (t2 - t1) + " ms;");
        System.out.println("子串:" + len);

        String str1 = "abcabqqweqrqweqweqweqweqwqrweqwwwwwwwwwwwweeeeeeeeeeeeeeeeeeeeeeeeeqwreteyrtyrtyrtyrtyrtyrtytiyuiyuiyitretrypoiuytrekjhgfds;lkjhgfdsmnbvcxzcdbb";
        long t11 = System.currentTimeMillis();
        int len1 = new Solution1().lengthOfLongestSubstring(str);
        long t21 = System.currentTimeMillis();
        System.out.println("time cost is " + (t21 - t11) + " ms;");
        System.out.println("子串:" + len1);
    }

}
