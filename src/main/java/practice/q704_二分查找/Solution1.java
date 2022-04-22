package practice.q704_二分查找;

/**
 *
 *
 */
public class Solution1 {
    public int search(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) l = mid;
            else r = mid - 1;
        }
        return nums[r] == t ? r : -1;
    }

    public int search2(int[] nums, int t) {
        if (nums == null) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == t) {
                return mid;
            } else if (nums[mid] < t) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == t) {
            return left;
        }
        if (nums[right] == t) {
            return right;
        }
        return -1;
    }

}