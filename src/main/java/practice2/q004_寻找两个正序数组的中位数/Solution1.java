package practice2.q004_寻找两个正序数组的中位数;

import java.util.Arrays;

/**
 * 解法一
 * 简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
 * 时间复杂度：遍历全部数组 (m+n)
 * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
 */
public class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr = merge(nums1, nums2);
        int len = newArr.length;
        if (len % 2 == 0) {
            return (double) (newArr[len / 2] + newArr[len / 2 - 1]) / 2;
        } else {
            return (double) (newArr[len / 2]) / 2;
        }
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m + n];
        int i = 0, j = 0, idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[idx++] = nums1[i++];
            } else {
                res[idx++] = nums2[j++];
            }
        }
        while (i < m) {
            res[idx++] = nums1[i++];
        }
        while (j < n) {
            res[idx++] = nums2[j++];
        }
        return res;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] arr = new int[n + m];
        int idx = 0;
        for (int i : nums1) arr[idx++] = i;
        for (int i : nums2) arr[idx++] = i;
        Arrays.sort(arr);
        int l = arr[(n + m) / 2], r = arr[(n + m - 1) / 2];
        return (l + r) / 2.0;
    }
}
