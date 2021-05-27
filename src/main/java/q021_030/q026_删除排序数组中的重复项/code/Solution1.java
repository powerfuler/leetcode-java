package q021_030.q026_删除排序数组中的重复项.code;

/**
 * 双指针 o(n)
 *
 * 首先注意数组是有序的，那么重复的元素一定会相邻。
 * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
 * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
 * 1.比较 p 和 q 位置的元素是否相等。
 *  如果相等，q 后移 1 位
 *  如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
 *  重复上述过程，直到 q 等于数组长度。
 * 返回 p + 1，即为新数组长度。
 *
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public int removeDuplicates3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public int removeDuplicates4(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                if (fast - slow > 1) {
                    nums[slow + 1] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}