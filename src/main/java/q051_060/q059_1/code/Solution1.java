package q051_060.q059_1.code;

/**
 * 时间复杂度：$O(n^2)$
 * 空间复杂度：$O(n^2)$
 *
 * 按照「方向」进行模拟
 *
 * 事实上，我们还可以根据「方向」进行模拟。
 *
 * 因为每一圈的构建都是按照特定的「四个方向」进行的。
 *
 * 这种解法更为简洁。而触发方向转换的时机：
 *
 * 1. 下一步发生位置溢出
 * 2. 回到了本圈的起点
 */
public class Solution1 {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        // 定义四个方向
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int x = 0, y = 0, d = 0, i = 1; i <= n * n; i++) {
            ans[x][y] = i;

            // 下一步要到达的位置
            int nx = x + dirs[d][0], ny = y + dirs[d][1];
            // 如果下一步发生「溢出」或者已经访问过（说明四个方向已经走过一次）
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || ans[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dirs[d][0];
                ny = y + dirs[d][1];
            }

            x = nx;
            y = ny;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().generateMatrix(3));
    }
}