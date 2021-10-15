package company.bytedance.q101_q200.q0136_1.code;

public class Solution3 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n:nums)
        {
            // 异或
            res ^= n;
        }
        return res;
    }
}