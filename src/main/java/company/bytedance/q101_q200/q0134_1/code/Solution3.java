package company.bytedance.q101_q200.q0134_1.code;

/**
 * 题目要求「合法起点」的下标，因此我们可以枚举所有的「起点」
 * 然后按照「油量 & 成本」模拟一遍，看是否能走完一圈
 * 共有 $n$ 个「起点」，检查某个「起点」合法性的复杂度是 $O(n)$ 的。因此整体复杂度为 $O(n^2)$ 的。
 *
 * 时间复杂度：$O(n^2)$
 * 空间复杂度：$O(1)$
 *
 * 超时
 */
public class Solution3 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            // 直接跳过第一步都不满足的起点
            if (gas[start] < cost[start]) continue;
            // 剩余油量
            int cur = gas[start] - cost[start];
            // 所在位置
            int idx = (start + 1) % n;
            while (idx != start) {
                cur += gas[idx] - cost[idx];
                // 如果剩余油量为负数，说明无法离开当前位置，走到下一位置
                if (cur < 0) break;
                idx = (idx + 1) % n;
            }
            if (idx == start) return start;
        }
        return -1;
    }

}