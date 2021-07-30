package company.bytedance.q101_q200.q0128_1.code;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> distances = new HashMap<>();

        int result = 1;

        for (int num : nums) {
            if (distances.containsKey(num)) {
                continue;
            }

            // 查找向左能够延伸的最长距离
            int left = distances.getOrDefault(num - 1, 0);
            // 查找向右能够延伸的最长距离
            int right = distances.getOrDefault(num + 1, 0);

            // 更新此时的左右边界所表示的区块大小
            distances.put(num - left, left + right + 1);
            distances.put(num + right, left + right + 1);

            // 数组中可能存在重复元素，记录当前元素，避免再次访问
            distances.put(num, left + right + 1);

            result = Math.max(result, left + right + 1);
        }
        return result;
    }
}