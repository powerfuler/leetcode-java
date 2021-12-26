package gp.DP.L63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if(obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            }else {
                break;
            }
        }
        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
//        int[][] obstacleGrid = {{1, 0}, {0, 0}};
        int[][] obstacleGrid = {{1, 0, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}