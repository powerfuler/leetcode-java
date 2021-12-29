package gp.DFS.L78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, result, list, 0);
        return result;
    }
    
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> list, int pos) {
        
        /*
            []
            1
                1, 2
                    1, 2, 3
                1, 3
            2
                2, 3
            3
        */
            
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}