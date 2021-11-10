package company.bytedance.q101_q200.q0179_1.code;

/**
 * 快排+数学计算
 *
 * 方法一：数学计算法：
 * 比如：int x = 12; int y = 345
 * x 拼接 y = 12345 = 12 * 1000 + 345 = x * 1000 + y;
 * y 拼接 x = 34512 = 345 * 100 + 12 = y * 100 + x;
 * 上面的1000是哪里来的？因为y是3位数。上面的100是哪里来的？因为x是2位数；明白这个思想就能写出代码了
 *
 */
class Solution {
    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            long x = 10;
            long y = 10;
            while (nums[i] >= x) {
                x *= 10;
            }
            while (pivot >= y) {
                y *= 10;
            }
            if (nums[i] * y + pivot > nums[i] + pivot * x) {
                index += 1;
                swap(nums, index, i);
            }
        }
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
//        int[] nums = {0, 0, 0, 0, 0};
        String s = new Solution().largestNumber(nums);
        System.out.println(s);
    }

}