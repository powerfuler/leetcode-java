package gp.doublepointer.L611;

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int total = 0;
        Arrays.sort(nums);
        for (int k = nums.length - 1; k >= 2; k--) {
            int start = 0, end = k - 1;
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