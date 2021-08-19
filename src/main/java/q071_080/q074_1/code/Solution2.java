package q071_080.q074_1.code;

/**
 * 时间复杂度：$O(\log{(m * n)})$
 * 空间复杂度：$O(1)$
 *
 * 当然，因为将二维矩阵的行尾和行首连接，也具有单调性。
 * 我们可以将「二维矩阵」当做「一维矩阵」来做。
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (matrix[mid / n][mid % n] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return matrix[r / n][r % n] == target;
    }
}