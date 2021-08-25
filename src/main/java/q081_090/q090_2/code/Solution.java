package q081_090.q090_2.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
class Solution {
    // 存放符合条件结果的集合
    List<List<Integer>> result = new ArrayList<>();
    /**
     * 用来存放符合条件结果
     */
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] visited;
    int length;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        // 首先排序，让相同的两个元素排到一起去，便于去重
        Arrays.sort(nums);
        length = nums.length;
        // 使用 visited 数组来记录哪一个元素在当前路径中被使用了
        visited = new boolean[length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex) {
        // 首先加入当前路径
        result.add(new ArrayList<>(path));
        if (startIndex >= length) {
            return;
        }
        // 从 startIndex 开始遍历每一个元素，尝试加入路径中
        for (int i = startIndex; i < length; i++) {
            // 如果当前元素和前一个元素相同，而且前一个元素没有被访问，说明前一个相同的元素在当前层已经被用过了
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            // 放到路径中
            path.add(nums[i]);
            // 记录下来，用过了当前的元素
            visited[i] = true;
            // 向下一个递归
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            // 回溯
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(new Solution().subsetsWithDup(nums));
    }
}