package practice.q0200_岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int r, int c) {
        int[] kx = {1, -1, 0, 0};
        int[] ky = {0, 0, 1, -1};
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        xQueue.offer(r);
        yQueue.offer(c);
        grid[r][c] = '2';

        while (!xQueue.isEmpty()) {
            int curX = xQueue.poll();
            int curY = yQueue.poll();

            for (int k = 0; k < 4; k++) {
                int newX = curX + kx[k];
                int newY = curY + ky[k];

                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == '1') {
                    grid[newX][newY] = '2';
                    xQueue.offer(newX);
                    yQueue.offer(newY);
                }
            }
        }
    }

}