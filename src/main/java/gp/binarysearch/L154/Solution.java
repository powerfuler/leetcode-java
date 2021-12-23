package gp.binarysearch.L154;

class Solution {
    public static void main(String[] args) {
        int[] num = {3, 3, 1,3};
        System.out.println(new Solution().findMin(num));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end && nums[0] == nums[end]) end--;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                if (nums[end] >= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}