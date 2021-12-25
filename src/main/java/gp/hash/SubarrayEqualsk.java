package gp.hash;

import java.util.HashMap;
import java.util.Map;

class SubarrayEqualsk {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int ans = 0;
        int temp = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                ans += map.get(nums[i] - k);
            }
            temp = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], temp);
        }
        return ans;
    }
}