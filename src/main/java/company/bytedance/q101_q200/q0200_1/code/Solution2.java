package company.bytedance.q101_q200.q0200_1.code;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int number = 0;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int[] kx = {1, -1, 0, 0};
        int[] ky = {0, 0, 1, -1};

        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        xQueue.offer(i);
        yQueue.offer(j);
        visited[i][j] = true;

        while (!xQueue.isEmpty()) {
            int currX = xQueue.poll();
            int currY = yQueue.poll();

            for (int k = 0; k < 4; k++) {
                int newX = currX + kx[k];
                int newY = currY + ky[k];

                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY]) {
                    if (grid[newX][newY] == '1') {
                        xQueue.offer(newX);
                        yQueue.offer(newY);
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}