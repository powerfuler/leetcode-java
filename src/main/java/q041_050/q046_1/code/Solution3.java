package q041_050.q046_1.code;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> list = new ArrayList<>();
        helper(result, nums, list);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(result, nums, list);
            list.remove(list.size() - 1);
        }
    }
}