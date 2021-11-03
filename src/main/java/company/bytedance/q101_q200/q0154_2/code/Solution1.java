package company.bytedance.q101_q200.q0154_2.code;

/**
 *
 *
 */
public class Solution1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r && nums[0] == nums[r]) r--;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r + 1 < n ? nums[r + 1] : nums[0];
    }

    public static void main(String[] args) {
        int[] ss = new int[]{2, 2, 2, 0, 1, 2};
        int min = new Solution1().findMin(ss);
        System.out.println(min);
    }
}