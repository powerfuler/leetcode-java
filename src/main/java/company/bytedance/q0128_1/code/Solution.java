package company.bytedance.q0128_1.code;

import java.util.HashSet;

public class Solution {

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
        //List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            //list.add(nums[i]);
            set.add(nums[i]);
        }

        int maxLength = Integer.MIN_VALUE;
        for (int a : set) { // set -> list
            if (set.contains(a - 1)) {
                continue;
            } else {
                int len = 0;
                while (set.contains(a++)) {
                    len++;
                }
                maxLength = Math.max(len, maxLength);
            }
        }
        return maxLength;
    }
}