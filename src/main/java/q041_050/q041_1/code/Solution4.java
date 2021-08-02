package q041_050.q041_1.code;

import java.util.Arrays;

/**
 * 二分查找（时间复杂度不符合要求）
 * 根据刚才的分析，这个问题其实就是要我们查找一个元素，而查找一个元素，如果是在有序数组中查找，会快一些；
 * 因此我们可以将数组先排序，再使用二分查找法从最小的正整数 1 开始查找，找不到就返回这个正整数；
 * 这个思路需要先对数组排序，而排序使用的时间复杂度是 O(NlogN)，是不符合这个问题的时间复杂度要求
 */
public class Solution4 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i <= len; i++) {
            int res = binarySearch(nums, i);
            if (res == -1) {
                return i;
            }
        }
        return len + 1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}