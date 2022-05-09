package practice.q015_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                return ans;
            }

            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                int tem = cur + nums[L] + nums[R];
                if (tem == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    ans.add(list);
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (tem < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution1().threeSum(nums);
        System.out.println(lists);
    }
}
