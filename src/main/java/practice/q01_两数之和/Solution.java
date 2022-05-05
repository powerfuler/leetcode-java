package practice.q01_两数之和;

import q001_010.q001_两数之和.code.Solution1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length==0) return null;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11,15};
        int target = 9;
        int[] result = new Solution1().twoSum(nums, target);
        System.out.println( result[0] + ", " + result[1]);
    }
}