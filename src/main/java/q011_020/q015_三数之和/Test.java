package q011_020.q015_三数之和;

/*
*/

import q011_020.q015_三数之和.code.Solution1;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4, 4, -3, -5, 8, 9, 10, -7, 8};
        long t4 = System.currentTimeMillis();
        List<List<Integer>> lists = new Solution1().threeSum(nums);
        long t5 = System.currentTimeMillis();

        System.out.println("time cost is " + (t5 - t4) + "ms; list :" + lists);
    }
}
