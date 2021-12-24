package gp.sort.L912;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int j = 0; j < array.length; j++) {
            array[j] = (int) (Math.random() * 10000);
        }
        new QuickSort().sortArray(array);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (nums[left] < pivot && left <= right) {
                left++;
            }
            while (nums[right] > pivot && left <= right) {
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

    public void swap(int[] nums, int index1, int index2) {
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }
}
