package q031_040.q039_组合总和.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路
 * dfs递归+回溯+剪枝
 *
 * 思路：
 * 这个和前面的列举所有情况一样。很容易想到用递归穷举所有排列。但是难点在于数字可以重复使用。以前是遍历过得元素不再使用，但现在遍历过得元素在下一个递归还可以再次遍历。
 * 并且为了防止遍历结果重复，比如【2，3】和【3，2】这种重复的情况。我们遍历的时候只能从前往后遍历。以前的做法是每个递归中都遍历0-n，用记录标志判断这个元素是否遍历过。
 * 现在不行，现在是比如第一个递归从0-n，第二个递归就是从1-n，如此递推。使用深度优先递归方法，当路径元素和等于目标和时结束。添加到结果集中。因为我们这个会重复遍历当前元素，为了避免陷入无限递归之中还需要先对数组排序，for循环数组的时候判断目标和-当前数组元素怒是否小于0，如果是，超过了目标和，当前及以后的元素怒都是无意义的。停止循环，这就是所谓的剪枝。
 *
 * 做法：
 * 1、先排序
 * 2、定义结果集。回溯路径集。作为参数传递到递归方法中。返回结果集
 * 3、递归方法：深度优先递归
 * 4、结束条件。目标和==0时结束。添加到结果集中
 * 5、否则遍历数组。从上一个递归遍历位置处开始遍历。同时结束条件还需要剪枝。剩余目标和大于当前数组值时结束。
 * 6、当前元素添加到回溯集。递归调用。更新剩余目标和。当前遍历索引传入。
 * 7、回溯
 * 时间复杂度：O（n*n），空间复杂度：O（target）。最坏的情况是元素1遍历target次，和为target
 *
 */

public class Solution1 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 先排序
        Arrays.sort(candidates);
        //从0索引开始遍历
        dfsCombineSum(candidates, target, res, path, 0);
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
    private static void dfsCombineSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start) {
        // 剩余目标和为0时结束
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //从索引start开始遍历。结束条件有两个。一个是遍历到底时结束。另一个是剩余目标和大于当前数组值才遍历（剪枝）。这两个不能换位置，否则会索引溢出
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            // 添加到回溯路径集
            int cur = candidates[i];
            path.add(cur);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            //递归调用。传入新的剩余目标和。传入当前遍历索引
            dfsCombineSum(candidates, target - cur, res, path, i);
            //回溯
            path.remove(path.size() - 1);
            System.out.println("递归之后 => " + path);
        }
    }
}