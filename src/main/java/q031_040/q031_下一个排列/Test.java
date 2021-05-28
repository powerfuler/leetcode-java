package q031_040.q031_下一个排列;


import q031_040.q031_下一个排列.code.Solution1;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 5, 7, 6, 4};
        long t1 = System.currentTimeMillis();
        int[] ints = new Solution1().nextPermutation(nums);
        System.out.println(ints);
        long t2 = System.currentTimeMillis();
    }
}
