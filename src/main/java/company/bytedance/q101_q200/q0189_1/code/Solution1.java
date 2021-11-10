package company.bytedance.q101_q200.q0189_1.code;

/**
 * 如果没有空间复杂度为 `O(1)` 这个限制，这道题相对来说会简单很多，需要做的仅仅复制一份数组，然后将 `[n - k, n]` 区间上的元素覆盖在数组的开头，接着遍历并覆盖剩下的元素即可。
 *
 * 不能使用额外的空间意味着你只能从数组本身来入手，这里我们可以使用反转数组来解决这道题，这是一个 rotate 数组的小技巧。
 * 如果仔细观察，你会发现 **数组经过 rotate 后会变成两个连续的区间段**，这两个区间段中的元素顺序和 rotate 之前的顺序是一样的。
 * 首先我们对数组当中所有的元素进行反转，然后分别对这两个区间进行反转，这样就可以保证区间内的顺序和之前一样，你可以看看动图或者自己动手尝试一下，
 * 这里并没有复杂的知识点，只是数组操作上的小技巧，了解了之后，可以运用到其他 rotate 数组的场景中。
 *
 */
public class Solution1 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        new Solution1().rotate(nums, k);
        System.out.println(nums.toString());
    }
}