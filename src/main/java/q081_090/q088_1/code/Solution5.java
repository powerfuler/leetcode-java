package q081_090.q088_1.code;

public class Solution5 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int[] arr = new int[length];
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
        System.arraycopy(arr, 0, nums1, 0, length);
    }
}