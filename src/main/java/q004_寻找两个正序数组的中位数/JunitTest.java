package q004_寻找两个正序数组的中位数;

import org.junit.Assert;
import org.junit.Test;
import q004_寻找两个正序数组的中位数.code.Solution3;
import q004_寻找两个正序数组的中位数.code.Solution2;

public class JunitTest {

    @Test
    public void test() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Solution3 solution = new Solution3();
        Assert.assertEquals(2, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        Solution3 solution = new Solution3();
        Assert.assertEquals(2.5, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test3() {
        int[] nums1 = {6};
        int[] nums2 = {1, 2, 3, 4, 5};
        Solution3 solution = new Solution3();
        Assert.assertEquals(3.5, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test4() {
        int[] nums1 = {1, 3};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        Solution3 solution = new Solution3();
        Assert.assertEquals(3, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test5() {
        int[] nums1 = {1, 4, 5, 9};
        int[] nums2 = {1, 2, 3, 6, 7, 8, 9, 10};
        Solution3 solution = new Solution3();
        Assert.assertEquals(5.5, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test6() {
        int[] nums1 = {4, 5};
        int[] nums2 = {1, 2, 3, 6, 7, 8, 9, 10};
        Solution3 solution = new Solution3();
        Assert.assertEquals(5.5, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test7() {
        int[] nums1 = {9, 10};
        int[] nums2 = {1, 2, 3, 6, 7, 8, 9, 10};
        Solution3 solution = new Solution3();
        Assert.assertEquals(7.5, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }

    @Test
    public void test8() {
        int[] nums1 = {2};
        int[] nums2 = {1, 2, 3, 6, 7, 8};
        Solution3 solution = new Solution3();
        Assert.assertEquals(4.5, new Solution2().findMedianSortedArrays(nums1, nums2), 0.000001);
    }
}
