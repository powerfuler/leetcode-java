package q041_050.q041_1.code;

/**
 ** 时间复杂度：每个数字应该被挪动的数都会被一次性移动到目标位置。复杂度为 $O(n)$
 * 空间复杂度：$O(1)$
 *
 * 基本思路为：
 *
 * 1. 按照桶排序思路进行预处理：
 * 保证 1 出现在 `nums[0]` 的位置上，2 出现在 `nums[1]` 的位置上，…，`n` 出现在 `nums[n - 1]` 的位置上。不在 `[1, n]` 范围内的数不用动。
 * 例如样例中 `[3,4,-1,1]` 将会被预处理成 `[1,-1,3,4]`。
 * 2. 遍历 `nums`，找到第一个不在应在位置上的 `[1, n]` 的数。如果没有找到，说明数据连续，答案为 `n + 1`
 * 例如样例预处理后的数组 `[1,-1,3,4]` 中第一个 `nums[i] != i + 1` 的是数字 2（i = 1）。
 */
public class Solution1 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}