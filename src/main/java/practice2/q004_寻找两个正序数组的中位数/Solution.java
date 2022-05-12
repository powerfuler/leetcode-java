package practice2.q004_寻找两个正序数组的中位数;

/**
 首先，我们可以只考虑数字总个数为奇数的情况。让我们看下下图：
 ![](../Animation/image1.PNG)
 蓝框是中位数左边的数（包括中位数），而橘框则为中位数右边的数。

 3个显然的规则：
 1.两个数组的蓝框总个数=(数字总个数+1)/2;
 2.所有蓝框内的数都小于橘框内的数
 3.中位数为蓝框中最大的那一位（即数组1蓝框最后一位，或数组2蓝框最后一位）
 ![](../Animation/image2.PNG)
 如图，我们要找到一组A，B，满足上面3条规则。
 对于规则1，我们在数组1中找任意A，然后根据规则1就能推算出对应的B的位置。
 对于规则2，由于数组1和2都是有序数组，即X1<A<Y1;X2<B<Y2。我们实际上只需要判断A是否小于Y2，以及B是否小于Y2。
 对于规则3，由于数组1和2都是有序数组，因此中位数为A,B中较大的那一项。

 那么具体该如何操作呢?
 由于数组1和2都是有序数组，且题目要求O(log(m+n))复杂度，我们明显应考虑二分法。
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 使num1成为较短数组,不仅可以提高检索速度,同时可以避免一些边界问题
        if(nums1.length> nums2.length){
            int[] tem = nums1;
            nums1 = nums2;
            nums2 = tem;
        }
        int len1 = nums1.length,len2 = nums2.length;
        // 两数组合并&排序后,左半边的长度
        int leftLen = (len1+len2+1)/2;
        // 对数组1进行二分检索
        int start = 0 ,end = len1;
//        int[] nums1 = new int[]{3, 4, 15, 18};
//        int[] nums2 = new int[]{2, 6, 7, 9, 11, 13, 15};
        while (start <= end){
            // 找到两数组被测数A,B位置，两数组中位数，count1 = 2 表示 num1 数组的第2个数字,索引下标为1
            int count1 = start + (end-start)/2;
            int count2 = leftLen-count1;

        }

    }




















}
