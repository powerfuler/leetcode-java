package q071_080.q073_1.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路一: 用O(m+n)额外空间
 *
 * 两遍扫matrix,第一遍用集合记录哪些行,哪些列有0;第二遍置0
 */
class Solution2 {
    public void setZeroes(int[][] matrix) {
        // 记录哪一行，那一列，包含了0
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        // 把包含0的哪一行那一列的矩阵元素设置为0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (row_zero.contains(i) || col_zero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}