package q4_寻找两个正序数组的中位数;

import q4_寻找两个正序数组的中位数.code.Solution2;

/*
*/

public class Test {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
//                {2, 4};

        long t1 = System.currentTimeMillis();
        double median = new Solution2().findMedianSortedArrays(nums1, nums2);
        long t2 = System.currentTimeMillis();

        System.out.println("time cost is " + (t2 - t1) + " ms;median = " + median);

    }

}
