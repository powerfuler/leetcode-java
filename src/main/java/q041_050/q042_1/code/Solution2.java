package q041_050.q042_1.code;

/**
 * 暴力法o(n^2) 找出每个元素（柱子）上面的水量，可提前存储最大高度数组（两个左和右），最后遍历一次优化为o(n)
 *
 * 对于每根柱子而言，我们只需要找出「其左边最高的柱子」和「其右边最高的柱子」。
 * 对左右的最高柱子取一个最小值，再和当前柱子的高度做一个比较，即可得出当前位置可以接下的雨水。
 * 同时，边缘的柱子不可能接到雨水（某一侧没有柱子）。
 */
public class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int cur = height[i];

            // 获取当前位置的左边最大值
            int l = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) l = Math.max(l, height[j]);
            if (l <= cur) continue;

            // 获取当前位置的右边边最大值
            int r = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) r = Math.max(r, height[j]);
            if (r <= cur) continue;

            // 计算当前位置可接的雨水
            ans += Math.min(l, r) - cur;
        }
        return ans;
    }
}