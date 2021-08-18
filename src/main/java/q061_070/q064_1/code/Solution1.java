package q061_070.q064_1.code;

/**
 * 动态规划
 *
 * 转移方程：
 *
 * 题目要求，只能向右或向下走，换句话说，当前单元格 (i,j) 只能从左方单元格 (i−1,j) 或上方单元格 (i,j−1) 走到，因此只需要考虑矩阵左边界和上边界。
 *
 * 走到当前单元格 (i,j) 的最小路径和 == “从左方单元格 (i−1,j) 与 从上方单元格 (i,j−1) 走来的 两个最小路径和中较小的 ” ++ 当前单元格值 grid[i][j] 。
 * 具体分为以下 4 种情况：
 *
 * 1、当左边和上边都不是矩阵边界时：
 * 即当i != 0 j !=0时，dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
 *
 * 2、当只有左边是矩阵边界时：
 *   即当i = 0 j !=0时，dp[i][j] = dp[i][j - 1] + grid[i][j];
 *
 * 3、当只有上边是矩阵边界时：
 *   即当i != 0 j =0时，dp[i][j] = dp[i - 1][j] + grid[i][j];
 *
 * 4、当左边和上边都是矩阵边界时：
 *   即当i = 0 j =0时，dp[i][j] = grid[i][j];
 *
 * dp 初始化即可，不需要修改初始 0 值。
 *
 * 返回值：
 * 返回 dp 矩阵右下角值，即走到终点的最小路径和。
 * 其实我们完全不需要建立 dp 矩阵浪费额外空间，直接遍历 grid[i][j] 修改即可。这是因为：grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j] ；、
 * 原 grid 矩阵元素中被覆盖为 dp 元素后（都处于当前遍历点的左上方），不会再被使用到。
 *
 * 复杂度分析：
 * 时间复杂度 O(M×N) ： 遍历整个 grid 矩阵元素。
 * 空间复杂度 O(1)： 直接修改原矩阵，不使用额外空间。
 *
 */
public class Solution1 {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum1(int[][] grid) {
        int width = grid[0].length, high = grid.length;
        if (high == 0 || width == 0) {
            return 0;
        }
        // 初始化
        for (int i = 1; i < high; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < width; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[high - 1][width - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution1().minPathSum1(obstacleGrid));
    }
}