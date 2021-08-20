package q071_080.q080_1.code;

/**
 * 双指针，快慢指针
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int fast = 0;
        int slow = 0;

        while (fast < n) {
            if (slow < 2 || nums[fast] > nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 4};
        int i = new Solution().removeDuplicates(nums);
        System.out.println(i);
    }
}