package company.bytedance.q101_q200.q0198_1.code;

public class Solution11 {
    public int rob(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[length];
    }

    public int rob1(int[] nums) {
        int pre = 0, current = 0;
        for (int num : nums) {
            int temp = Math.max(current, pre + num);
            pre = current;
            current = temp;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int rob = new Solution11().rob1(nums);
        System.out.println(rob);
    }

}
