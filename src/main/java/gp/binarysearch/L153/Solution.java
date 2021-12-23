package gp.binarysearch.L153;

class Solution {
    public static void main(String[] args) {
        int[] num = {4, 5, 6, -7, 0, 1, 2};
        System.out.println(new Solution().findMin(num));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                if (nums[end] > nums[mid]) {
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