package q041_050.q042_1.code;

/**
 * ### 面积差值解法
 * 事实上，我们还能利用「面积差值」来进行求解。
 * 我们先统计出「柱子面积」$sum$ 和「以柱子个数为宽、最高柱子高度为高的矩形面积」$full$。
 * 然后分别「从左往右」和「从右往左」计算一次最大高度覆盖面积 $lSum$ 和 $rSum$。
 * 显然会出现重复面积，并且重复面积只会独立地出现在「山峰」的左边和右边。**
 * 利用此特性，我们可以通过简单的等式关系求解出「雨水面积」：
 */
public class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int cur = height[i];
            sum += cur;
            max = Math.max(max, cur);
        }
        int full = max * n;

        int lSum = 0, lMax = 0;
        for (int i = 0; i < n; i++) {
            lMax = Math.max(lMax, height[i]);
            lSum += lMax;
        }

        int rSum = 0, rMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            rSum += rMax;
        }

        return lSum + rSum - full - sum;
    }
}