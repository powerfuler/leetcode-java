package practice2.q004_寻找两个正序数组的中位数.code;

/**
 * 二分法
 *
 *  上边的两种思路，时间复杂度都达不到题目的要求 O(log(m+n)。看到 log，很明显，我们只有用到二分的方法才能达到。
 *  我们不妨用另一种思路，题目是求中位数，其实就是求第 k 小数的一种特殊情况，而求第 k 小数有一种算法。
 *  解法二中，我们一次遍历就相当于去掉不可能是中位数的一个值，也就是一个一个排除。由于数列是有序的，其实我们完全可以一半儿一半儿的排除。
 *  假设我们要找第 k 小数，我们可以每次循环排除掉 k/2 个数
 *
 * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）。
 * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)。
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int n = nums1.length;
        int m = nums2.length;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        if (total % 2 != 0) {
            return getKth(nums1, 0, n - 1, nums2, 0, m - 1, left);
        } else {
            //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
            return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                    getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
        }
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0)
            return nums2[start2 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        // nums1[start, ..., ia-1, ia, ..., nums1.length]
        // nums2[start, ..., ib-1, ib, ..., nums2.length]
        // 说明子数组nums1[start, ..., ia-1]可以弃了，要找的值在nums1[ia, ..., nums1.length]
        // 和nums2[start, ..., ib-1, ib, ..., nums2.length]中
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
