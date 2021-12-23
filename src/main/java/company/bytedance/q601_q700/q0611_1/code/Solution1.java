package company.bytedance.q601_q700.q0611_1.code;

import java.util.Arrays;

public class Solution1 {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int k = nums.length - 1; k >= 2; k--) {
            int start = 0;
            int end = k - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[k]) {
                    total = total + (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return total;
    }
}