package q041_050.q047_1.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法(DFS深度优先遍历) o(n*n!)
 */
public class Solution1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            System.out.println("  递归之前 => " + path);
            dfs(nums, len, depth + 1, path, used, res);
            // 状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
            used[i] = false;
            path.remove(depth);
            System.out.println("递归之后 => " + path);
        }
    }
}