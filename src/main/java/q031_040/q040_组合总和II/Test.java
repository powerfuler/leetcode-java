package q031_040.q040_组合总和II;

/*
 */

import q031_040.q040_组合总和II.code.Solution1;

import java.util.List;

/**
 * @author dingjianmin
 */
public class Test {
    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7, 5};
        int[] candidates = {2, 3, 5};
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        long t1 = System.currentTimeMillis();
        List<List<Integer>> lists = new Solution1().combinationSum2(candidates, target);
        long t2 = System.currentTimeMillis();
        System.out.println("输出 => " + lists);
    }
}
