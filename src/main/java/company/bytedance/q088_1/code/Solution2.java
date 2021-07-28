package company.bytedance.q088_1.code;

/**
 * * 时间复杂度：$O(n + m^2 log{m})$
 * * 空间复杂度：忽略递归开销，复杂度为 $O(1)$
 *
 * 也可以直接在 $nums1$ 进行合并操作，但是需要确保每次循环开始，$nums2$ 的指针指向的必然是最小的元素。
 * 因此，我们需要对 $nums2$ 执行局部排序。
 */
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (j < n) {
            if (i >= m) {
                nums1[i] = nums2[j++];
            } else {
                int a = nums1[i], b = nums2[j];
                if (a > b) swap(nums1, i, nums2, j);
                sort(nums2, j, n - 1);
            }
            i++;
        }
    }

    void sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, nums, j);
        }
        sort(nums, l, j);
        sort(nums, j + 1, r);
    }

    void swap(int[] nums1, int i, int[] nums2, int j) {
        int tmp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = tmp;
    }
}