package company.bytedance.q101_q200.q0153_1.code;

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        //升序数组，数组完全单调，第一个数最小
        if (nums[r] > nums[l]) {
            return nums[0];
        }
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];
    }
}