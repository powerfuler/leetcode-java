package q061_070.q070_1.code;

public class Solution3 {
    public int climbStairs(int n) {
        int[] array = new int[n + 2];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String[] args) {
        int i = new Solution3().climbStairs(1);
        System.out.println(i);
    }
}
