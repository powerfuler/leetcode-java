package company.bytedance.q101_q200.q0172_1.code;

/**
 *
 *
 */
public class Solution1 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}