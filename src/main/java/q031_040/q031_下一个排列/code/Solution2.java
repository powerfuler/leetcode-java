package q031_040.q031_下一个排列.code;

/**
 *  说明一下为啥倒着取，正着取易空指针、越界
 */
public class Solution2 {
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int firstIndex = -1;
        // 倒取一个个升序数组
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }
        // 倒序取第一个大于nums[firstIndex]的数组
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
        return nums;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}