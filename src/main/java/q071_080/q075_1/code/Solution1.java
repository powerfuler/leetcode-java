package q071_080.q075_1.code;

/**
 *
 *
 */
public class Solution1 {
    public void sortColors(int[] nums) {
        // zero表示数字0的右侧边界，one、two分别表示1 和 2 的右侧边界
        int zero = 0;
        int one = 0;
        int two = 0;

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            //记录下待处理的值
            int temp = nums[i];

            //不管怎样，我先给你填个2
            nums[two] = 2;
            two++;

            // <=1的话 1的右侧边界one要向右挪一格
            if (temp <= 1) {
                nums[one] = 1;
                one++;
            }

            //为0的话 0的右侧边界zero要向右挪一格
            if (temp == 0) {
                nums[zero] = 0;
                zero++;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int zero = 0, one = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            nums[i] = 2;
            if (tmp <= 1) {
                nums[one] = 1;
                one++;
            }
            if (tmp == 0) {
                nums[zero] = 0;
                zero++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new Solution1().sortColors(nums);
        System.out.println();
    }
}
