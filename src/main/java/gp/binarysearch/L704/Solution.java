package gp.binarysearch.L704;

class Solution {
    public static void main(String[] args) {
        int[] num = {-1, 0, 3, 5, 9, 12};
        System.out.println(new Solution().search(num, 9));
    }

    public int search(int[] nums, int t) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == t) {
                return mid;
            } else if (nums[mid] > t) {
                right = mid;
            } else {
                left = mid;
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