package gp.DP.L198;

class Solution {
    public int rob(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2 ; i< dp.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i-1] , dp[i-1]);
        }

        return dp[nums.length];
    }

    public int rob1(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int pre = 0, cur = 0, tmp;
        for (int num:nums){
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 1};
        int rob = new Solution().rob1(num);
        System.out.println(rob);
    }
}