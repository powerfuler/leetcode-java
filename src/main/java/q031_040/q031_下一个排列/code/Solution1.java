package q031_040.q031_下一个排列.code;

import java.util.Arrays;

public class Solution1 {
    public int[] nextPermutation(int[] nums) {
        int len = nums.length;
        // 找到一组升序的（i,j）
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                // 对i后面的数组升序排序
                Arrays.sort(nums, i, len);
                // 从前往后找到第一个大于nums[i]的值，交换两个值，交换后返回复核要求的值
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return nums;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return nums;
    }
}
