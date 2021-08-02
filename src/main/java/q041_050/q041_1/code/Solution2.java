package q041_050.q041_1.code;

import java.util.Arrays;

/**
 */
public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (Arrays.binarySearch(nums, i) < 0)
                return i;
        }
        return n + 1;
    }
}