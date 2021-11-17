package company.bytedance.q101_q200.q0191_1.code;

/**
 * 如果除去库函数之外，我们最容易想到的办法，肯定还是直观地统计二进制中每一位是否包含 1。
 *
 * 做法是：
 * 使用 n & 1得到二进制末尾是否为 1；
 * 把 n右移 1 位，直至结束。
 *
 */
public class Solution3 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += ((n >>> i) & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ss = 00000000000000000000000000001011;

        int i = new Solution3().hammingWeight(ss);
        System.out.println(i);
    }
}