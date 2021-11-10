package company.bytedance.q101_q200.q0167_1.code;

/**
 *
 * 初始化左指针 left 指向数组起始，初始化右指针 right 指向数组结尾。
 * 根据**已排序**这个特性，
 *
 * - （1）如果 numbers[left] 与 numbers[right] 的和 tmp 小于 target ，说明应该增加 tmp ，因此 left 右移指向一个较大的值。
 * - （2）如果 tmp大于 target ，说明应该减小 tmp ，因此 right 左移指向一个较小的值。
 * - （3）tmp 等于 target ，则找到，返回 left + 1 和 right + 1。（注意以 1 为起始下标）
 */
public class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ints = new Solution1().twoSum(numbers, target);

        System.out.println(ints);
    }
}