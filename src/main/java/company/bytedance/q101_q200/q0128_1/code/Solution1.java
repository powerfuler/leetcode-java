package company.bytedance.q101_q200.q0128_1.code;

import java.util.HashMap;

/**
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                // 左边
                int left = map.get(num - 1) == null ? 0 : map.get(num - 1);
                // 右边
                int right = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int cur = 1 + left + right;
                if (cur > res) {
                    res = cur;
                }
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return res;
    }
}