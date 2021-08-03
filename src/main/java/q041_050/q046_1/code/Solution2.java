package q041_050.q046_1.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 插队法 o((n-1)!+(n-2)!+···+2!+1!)
 */
public class Solution2 {
    public List<List<Integer>> fc(List<List<Integer>> nums, int c) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j <= nums.get(i).size(); j++) {
                List<Integer> temp = new ArrayList<>(nums.get(i));
                temp.add(j, c);
                result.add(temp);
            }
        }
        return result;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> to = new ArrayList<>();
        to.add(nums[0]);
        result.add(to);
        for (int i = 1; i < nums.length; i++) {
            result = fc(result, nums[i]);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        new Solution2().permute(new int[]{1, 2, 3});
        //4—>3！+2！+1！
    }
}
