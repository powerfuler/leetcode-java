package q031_040.q040_组合总和II.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路
 * 排序+dfs+回溯+剪枝
 * 思路：
 * 这个题目其实也不难。和前面的题目39一样的思路。dfs递归+回溯+剪枝。并且需要先排序。
 * 只要搞清楚这个递归过程，就能知道应该怎么样才能达到每个数字只能使用一次，并且解集不能有重复的组合。
 * 核心规则：for循环不是第一次循环，并且当前元素和前一个元素相同，跳过。即回溯之后跳过相同项
 * 核心代码：
 * if (i != start && candidates[i] == candidates[i-1]) continue;
 *
 *
 * 做法：
 * 1、先排序
 * 2、dfs递归：结束条件：剩余目标值为0时结束
 * 3、从上一层递归遍历到的索引+1开始循环，一直到遍历完。为了避免无效的遍历，还需要剪枝操作。同时遍历到剩余目标值大于当前元素值结束。
 * 4、循环里面判断。如果不是第一次循环，并且当前元素等于前一个元素，跳过。
 * 5、否则添加到路径集。递归调用。更新下一个递归的循环开始位置。调用完回溯
 * 6、返回结果集
 * 时间复杂度：O（n^2），本质是两层循环。递归是一层。递归里面又有一层。
 * 空间复杂度：O（n）
 *
 */

public class Solution1 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 先排序
        Arrays.sort(candidates);
        //从0索引开始遍历
        dfsCombineSum2(candidates, target, res, path, 0);
        return res;
    }

    /**
     * dfsCombineSum
     * @param candidates    数组
     * @param target    剩余目标和
     * @param res   结果集
     * @param path  回溯路径集
     * @param start for循环开始遍历索引
     */
    private static void dfsCombineSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start) {
        // 剩余目标和为0时结束
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //从索引start开始遍历。结束条件有两个。一个是遍历到底时结束。另一个是剩余目标和大于当前数组值才遍历（剪枝）。这两个不能换位置，否则会索引溢出
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            //核心代码：当不是第一次循环，并且当前元素等于前一个元素时，跳过。即回溯之后跳过相同项
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 添加到回溯路径集
            int cur = candidates[i];
            path.add(cur);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            //递归调用。传入新的剩余目标和。传入当前遍历索引
            dfsCombineSum2(candidates, target - cur, res, path, i + 1);
            //回溯
            path.remove(path.size() - 1);
            System.out.println("递归之后 => " + path);
        }
    }
}