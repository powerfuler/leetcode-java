package gp.binarysearch.L162;

class Solution {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 5, 6, 7, 8};
        System.out.println(new Solution().findPeakElement(num));
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] <= nums[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] <= nums[end] ? end : start;
    }
}