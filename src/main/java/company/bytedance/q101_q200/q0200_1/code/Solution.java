package company.bytedance.q101_q200.q0200_1.code;

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        int i = new Solution().numIslands(grid);
        System.out.println(i);
    }
}