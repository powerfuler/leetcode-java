package gp.DFS.L78;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(result, nums, list, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int pos) {
        result.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}