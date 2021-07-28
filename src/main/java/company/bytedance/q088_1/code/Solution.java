package company.bytedance.q088_1.code;

/**
 * * 时间复杂度：$O(m + n)$
 * * 空间复杂度：$O(1)$
 *
 * 将遍历方向调整为「从后往前」即可做到 $O(1)$ 空间复杂度。
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int idx = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
    }
}