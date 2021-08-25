package q081_090.q090_2.code;

import java.util.*;

/**
 * 回溯解法（Set）
 *
 * 由于是求所有的方案，而且数据范围只有 10，可以直接用爆搜来做。
 * 同时由于答案中不能包含相同的方案，因此我们可以先对原数组进行排序，从而确保所有爆搜出来的方案，都具有单调性，然后配合 Set 进行去重。
 */
public class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, ans);
        return new ArrayList<>(ans);
    }

    /**
     * @param nums 原输入数组
     * @param u 当前决策到原输入数组中的哪一位
     * @param cur 当前方案
     * @param ans 最终结果集
     */
    void dfs(int[] nums, int u, List<Integer> cur, Set<List<Integer>> ans) {
        // 所有位置都决策完成，将当前方案放入结果集
        if (nums.length == u) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // 选择当前位置的元素，往下决策
        cur.add(nums[u]);
        dfs(nums, u + 1, cur, ans);

        // 不选当前位置的元素（回溯），往下决策
        cur.remove(cur.size() - 1);
        dfs(nums, u + 1, cur, ans);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(new Solution1().subsetsWithDup(nums));
    }
}