package q041_050.q042_1.code;

/**
 * 首先对每根柱子进行遍历，求解每根柱子可以接下多少雨水，这个 $O(n)$ 操作肯定省不了。
 * 但在求解某根柱子可以接下多少雨水时，需要对两边进行扫描，求两侧的最大值。
 * 每一根柱子都进行这样的扫描操作，导致每个位置都被扫描了 $n$ 次。这个过程显然是可优化的。**
 * 换句话说：**我们希望通过不重复遍历的方式找到任意位置的两侧最大值。**
 * 问题转化为：**给定一个数组，如何求得任意位置的左半边的最大值和右半边的最大值。**
 * 一个很直观的方案是：**直接将某个位置的两侧最大值存起来。**
 * 我们可以先从两端分别出发，预处理每个位置的「左右最值」，这样可以将我们「查找左右最值」的复杂度降到 $O(1)$。
 * 整体算法的复杂度也从 $O(n^2)$ 下降到 $O(n)$。
 */
class Solution3 {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        // 由于预处理最值的时候，我们会直接访问到 height[0] 或者 height[n - 1]，因此要特判一下
        if (n == 0) return ans;

        // 预处理每个位置左边的最值
        int[] lm = new int[n];
        lm[0] = height[0];
        for (int i = 1; i < n; i++) lm[i] = Math.max(height[i], lm[i - 1]);

        // 预处理每个位置右边的最值
        int[] rm = new int[n];
        rm[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) rm[i] = Math.max(height[i], rm[i + 1]);

        for (int i = 1; i < n - 1; i++) {
            int cur = height[i];

            int l = lm[i];
            if (l <= cur) continue;

            int r = rm[i];
            if (r <= cur) continue;

            ans += Math.min(l, r) - cur;
        }
        return ans;
    }
}