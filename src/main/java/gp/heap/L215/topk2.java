package gp.heap.L215;

class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }
        
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        
        return nums[k];
    }
}