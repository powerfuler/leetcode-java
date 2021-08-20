package q071_080.q080_1.code;

/**
 * 时间复杂度：$O(n)$
 * 空间复杂度：$O(1)$
 *
 * 1. 首先我们先让前 2 位直接保留，得到 1,1
 * 2. 对后面的每一位进行继续遍历，能够保留的前提是与当前位置的前面 `k` 个元素不同（答案中的第一个 1），因此我们会跳过剩余的 1，将第一个 2 追加，得到 1,1,2
 * 3. 继续这个过程，这时候是和答案中的第 2 个 1 进行对比，因此可以得到 1,1,2,2
 * 4. 这时候和答案中的第 1 个 2 比较，只有与其不同的元素能追加到答案，因此剩余的 2 被跳过，3 被追加到答案：1,1,2,2,3
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) {
                nums[u++] = x;
            }
        }
        return u;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 4};
        int i = new Solution1().removeDuplicates(nums);
        System.out.println(i);
    }
}