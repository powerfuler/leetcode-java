package company.bytedance.q101_q200.q0179_1.code;

/**
 *方法二：快排+String
 *
 * 方法二：String
 * 比如：String x = "12"; String y = "345";
 * x 拼接 y = "12345" = x + y;
 * y 拼接 x = "34512" = y + x;
 * 因为数字在ASCII码表中是有顺序的，所以利用String的compareTo()方法，可以进行自然顺序的排序
 *
 */
public class Solution1 {
    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        quickSort(array, 0, nums.length - 1);
        if (array[0].equals("0")) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String str : array) {
            ans.append(str);
        }
        return ans.toString();
    }

    private void quickSort(String[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        String pivot = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if ((nums[i] + pivot).compareTo(pivot + nums[i]) > 0) {
                index += 1;
                swap(nums, index, i);
            }
        }
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(String[] nums, int l, int r) {
        String temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 30, 34, 5, 9};
        int[] nums = {0, 0, 0, 0, 0};
        String s = new Solution1().largestNumber(nums);
        System.out.println(s);
    }
}