package q031_040.q039_组合总和;

/*
 */

import q031_040.q039_组合总和.code.Solution1;

import java.util.List;

/**
 * @author dingjianmin
 */
public class Test {
    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7, 5};
        int[] candidates = {2,3,5};
//        int[] candidates = {2, 3, 6, 7};
        int target = 8;
        long t1 = System.currentTimeMillis();
        List<List<Integer>> lists = new Solution1().combinationSum(candidates, target);
        long t2 = System.currentTimeMillis();
        System.out.println("输出 => " + lists);
    }
}
