package gp.DP.L70;

class Solution1 {
    public int climbStairs(int n) {
        // n = 1 -> 1 (ways -> 1)
        // n = 2 -> 2(ways, 11, 2)
        // n = 3 -> 3(ways 111, 12, 21)
        // n = 4 -> 5(ways 1111,112,121,211,22)
        // n = 5 -> 8(ways 11111,1112,1121,1211,2111,221,212,122)
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
     
     /*  DFS
      public int climbStairs(int n) {
        // n == 1 -> 1
        // n == 2 -> 2
        // n == 0 -> 0
        if (n < 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
     */

    /* DP
    steps 
    0 1 2 3 4 5 ... 50
      1 2 3 5 8     ...
      public int climbStairs(int n) {
        // n == 1 -> 1
        // n == 2 -> 2
        // n == 0 -> 0
        if (n < 3) {
            return n;
        }
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
    */
    
/*
steps 
0 1 2
5 8 3
https://leetcode.com/problems/fibonacci-number/
https://leetcode.com/problems/house-robber/
*/