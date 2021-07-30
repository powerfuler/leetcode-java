package q081_090.q088_1.code;

import java.util.Arrays;

/**
 * * 时间复杂度：$O((m + n)log{(m + n)})$
 * * 空间复杂度：$O(1)$
 * 将 $nums2$ 的内容先迁移到 $nums1$ 去，再对 $nums1$ 进行排序。
 */

public class Solution3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}