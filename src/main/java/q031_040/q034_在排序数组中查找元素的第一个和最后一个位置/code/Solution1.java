package q031_040.q034_在排序数组中查找元素的第一个和最后一个位置.code;

public class Solution1 {
    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[]{-1, -1};
        searchIndex(nums, target, 0, len - 1);
        if (left == Integer.MAX_VALUE) {
            left = -1;
        }
        if (right == Integer.MIN_VALUE) {
            right = -1;
        }
        return new int[]{left, right};
    }

    public void searchIndex(int[] nums, int target, int start, int end) {
        int mid = start + ((end - start) >> 1);
        //返回条件
        if (start > end) {
            return;
        }
        if (nums[mid] == target) {
            //若比left小，更新left
            if (mid < left) {
                left = mid;
            }
            //若比right大,更新right
            if (mid > right) {
                right = mid;
            }
        }
        //在右子数组
        if (nums[mid] <= target) {
            searchIndex(nums, target, mid + 1, end);
        }
        //在左子数组
        if (nums[mid] >= target) {
            searchIndex(nums, target, start, mid - 1);
        }
        return;
    }
}