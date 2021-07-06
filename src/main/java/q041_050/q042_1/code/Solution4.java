package q041_050.q042_1.code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ### 单调栈解法
 *
 * 前面我们讲到，优化思路将问题转化为：**给定一个数组，如何求得任意位置的左半边的最大值和右半边的最大值。**
 * 但仔细一想，其实我们并不需要找两侧最大值，只需要找到两侧最近的比当前位置高的柱子就行了。
 *
 * 针对这一类找最近值的问题，有一个通用解法：**单调栈**。
 *
 * **单调栈其实就是在栈的基础上，维持一个栈内元素单调。**
 *
 * 在这道题，由于需要找某个位置两侧比其高的柱子（只有两侧有比当前位置高的柱子，当前位置才能接下雨水），我们可以维持栈内元素的单调递减。
 *
 * **PS. 找某侧最近一个比其大的值，使用单调栈维持栈内元素递减；找某侧最近一个比其小的值，使用单调栈维持栈内元素递增 ...**
 *
 * 当某个位置的元素弹出栈时，例如位置 `a` ，我们自然可以得到 `a` 位置两侧比 `a` 高的柱子：
 *
 * * 一个是导致 `a` 位置元素弹出的柱子（ `a` 右侧比 `a` 高的柱子）
 * * 一个是 `a` 弹栈后的栈顶元素（`a` 左侧比 `a` 高的柱子）
 *
 * 当有了 `a` 左右两侧比 `a` 高的柱子后，便可计算 `a` 位置可接下的雨水量。
 */
class Solution4 {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && height[i] > height[d.peekLast()]) {
                int cur = d.pollLast();

                // 如果栈内没有元素，说明当前位置左边没有比其高的柱子，跳过
                if (d.isEmpty()) continue;

                // 左右位置，并有左右位置得出「宽度」和「高度」
                int l = d.peekLast(), r = i;
                int w = r - l + 1 - 2;
                int h = Math.min(height[l], height[r]) - height[cur];
                ans += w * h;
            }
            d.addLast(i);
        }
        return ans;
    }
}