package gp.DP.L509;

class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;

        for (int i = 2; i < F.length; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }

    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        int[] F = new int[3];
        F[0] = 0;
        F[1] = 1;

        for (int i = 2; i < n+1; i++) {
            F[i%3] = F[(i - 1)%3] + F[(i - 2)%3];
        }
        return F[n%3];
    }


    public static void main(String[] args) {
        int fib = new Solution().fib1(4);
        System.out.println(fib);
    }
}