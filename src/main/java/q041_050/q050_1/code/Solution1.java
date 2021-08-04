package q041_050.q050_1.code;

/**
 *
 *
 */
public class Solution1 {
    public double myPow(double x, int n) {
        if (n < 0)
            return helper(1 / x, -n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double d = helper(x, n >>> 1);
        if (n % 2 == 0)
            return d * d;

        return d * d * x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 4));
    }
}