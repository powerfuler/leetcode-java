package gp.DP.L70;

class Solution {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int[] steps = new int[3];
        steps[0] = 1;
        steps[1] = 2;
        for (int i = 2; i < n; i++) {
            steps[i % 3] = steps[(i - 1) % 3] + steps[(i - 2) % 3];
        }
        return steps[(n - 1) % 3];
    }
}