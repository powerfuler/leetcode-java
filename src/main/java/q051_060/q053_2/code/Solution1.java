package q051_060.q053_2.code;

/**
 *贪心法 遍历一次 o(n)
 *
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int temp = sum;
        for (int i = 1; i < nums.length; i++) {
            temp = temp + nums[i];
            if (temp >= sum) {
                sum = temp;
            } else if (temp < 0) {
                temp = 0;
            }
            if (nums[i] > sum) {
                temp = nums[i];
                sum = nums[i];
            }
        }
        return sum;
    }
}