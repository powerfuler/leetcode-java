package company.bytedance.q501_q600.q0560_1.code;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            nums[i] += nums[i - 1];
        }
        int ans = 0;
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i] - k)) {
                ans += map.get(nums[i] - k);
            }
            int count = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int k = 3;
        Solution solution = new Solution();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}