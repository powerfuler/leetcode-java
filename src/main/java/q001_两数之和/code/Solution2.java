package q001_两数之和.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 一遍hash o(n)
 * 哈希表(字典)解法
 *
 * 思路：
 * 用字典(哈希表)存储每个数对应的索引
 * 当target - 当前数在字典(哈希表)中存在时，说明已存储的数和当前数相加可以达到目标target
 * 返回对应的索引 [hashmap[target - num], i]
 *
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
