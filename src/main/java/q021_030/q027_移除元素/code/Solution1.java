package q021_030.q027_移除元素.code;

/**
 * 双指针解法
 *本解法的思路与 26. 删除排序数组中的重复项 中的「双指针解法」类似。
 *
 * 根据题意，我们可以将数组分成「前后」两段：
 *  前半段是有效部分，存储的是不等于 val 的元素。
 *  后半段是无效部分，存储的是等于 val 的元素。
 *
 */
public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                swap(nums, i--, j--);
            }
        }
        return j + 1;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
