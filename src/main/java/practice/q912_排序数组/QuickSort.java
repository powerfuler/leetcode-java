package practice.q912_排序数组;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arrays = {3, 2, 5, 1, 4};
        int[] result = sortArray(arrays);
        for (int i = 0; i <= result.length - 1; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        sort(nums, start, right);
        sort(nums, left, end);
    }

    public static void swap(int[] nums, int i1, int i2) {
        int tem = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tem;
    }
}