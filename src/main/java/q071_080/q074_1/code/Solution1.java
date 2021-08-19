package q071_080.q074_1.code;

/**
 * 时间复杂度：$O(\log{m} + \log{n})$
 * 空间复杂度：$O(1)$
 *
 * 由于二维矩阵固定列的「从上到下」或者固定行的「从左到右」都是升序的。
 * 因此我们可以使用两次二分来定位到目标位置：
 * 1. 第一次二分：从第 0 列中的「所有行」开始找，找到合适的行 `row`
 * 2. 第二次二分：从 `row` 中「所有列」开始找，找到合适的列 `col`
 *
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 第一次二分：定位到所在行（从上往下，找到最后一个满足 matrix[x]][0] <= target 的行号）
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (matrix[mid][0] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        int row = r;
        if (matrix[row][0] == target) return true;
        if (matrix[row][0] > target) return false;

        // 第二次二分：从所在行中定位到列（从左到右，找到最后一个满足 matrix[row][x] <= target 的列号）
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (matrix[row][mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int col = r;

        return matrix[row][col] == target;
    }
}
