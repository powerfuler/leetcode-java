package q051_060.q059_1.code;

/**
 * 方向变量模拟路径 o(n)
 */
public class Solution2 {
    public int[][] generateMatrix(int x) {
        // 初始化n阶矩阵
        int[][] matrix = new int[x][x];
        if (x == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int i = 0;
        int j = 0;
        int direction = 1;
        int rsp = 1;
        while (true) {
            if (i < 0 || j < 0 || i == m || j == n || visited[i][j]) {
                break;
            }
            matrix[i][j] = rsp;
            rsp++;
            visited[i][j] = true;
            switch (direction) {
                case 1:
                    if (j + 1 == n || visited[i][j + 1]) {
                        i++;
                        direction = 2;
                    } else {
                        j++;
                    }
                    break;
                case 2:
                    if (i + 1 == m || visited[i + 1][j]) {
                        j--;
                        direction = 3;
                    } else {
                        i++;
                    }
                    break;
                case 3:
                    if (j == 0 || visited[i][j - 1]) {
                        i--;
                        direction = 4;
                    } else {
                        j--;
                    }
                    break;
                case 4:
                    if (visited[i - 1][j]) {
                        j++;
                        direction = 1;
                    } else {
                        i--;
                    }
                    break;
                default:
                    break;
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        int[][] ints = new Solution2().generateMatrix(4);
        System.out.println(ints);
    }
}
