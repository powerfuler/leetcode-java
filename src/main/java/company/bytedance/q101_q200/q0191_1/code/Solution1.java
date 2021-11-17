package company.bytedance.q101_q200.q0191_1.code;

/**
 *
 *
 */
public class Solution1 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += 1;
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int ss = 00000000000000000000000000001011;

        int i = new Solution1().hammingWeight(ss);
        System.out.println(i);
    }
}