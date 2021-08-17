package q051_060.q053_1.code;

/**
 * 动态规划
 *
 * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
 * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
 * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
 * 时间复杂度：O(n)
 *
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     *  动态规划 dp[i]表示以nums[i]结尾的最大子序和 o(n)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int rs = dp[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dp[i - 1] + nums[i];
            dp[i] = Math.max(nums[i], temp);
            rs = Math.max(rs, dp[i]);
        }
        return rs;
    }

    public int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -8, 4, 3, -9}));
    }
}
