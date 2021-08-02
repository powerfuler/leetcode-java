package q041_050.q045_1.code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * BFS
 * BFS 解法的复杂度是 $O(n^2)$
 */
public class Solution1 {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean[] st = new boolean[n];
        Deque<Integer> d = new ArrayDeque<>();
        st[0] = true;
        d.addLast(0);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                int idx = d.pollFirst();
                if (idx == n - 1)
                    return ans;
                for (int i = idx + 1; i <= idx + nums[idx] && i < n; i++) {
                    if (!st[i]) {
                        st[i] = true;
                        d.addLast(i);
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}