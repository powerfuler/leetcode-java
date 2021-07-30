package q081_090.q088_1.code;

/**
 *一个简单的做法是，创建一个和 $nums1$ 等长的数组 $arr$，使用双指针将 $num1$ 和 $nums2$ 的数据迁移到 $arr$。
 * 最后再将 $arr$ 复制到 $nums1$ 中。
 *
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        int[] arr = new int[total];
        int idx = 0;
        for (int i = 0, j = 0; i < m || j < n; ) {
            if (i < m && j < n) {
                arr[idx++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i < m) {
                arr[idx++] = nums1[i++];
            } else if (j < n) {
                arr[idx++] = nums2[j++];
            }
        }
        System.arraycopy(arr, 0, nums1, 0, total);
    }
}