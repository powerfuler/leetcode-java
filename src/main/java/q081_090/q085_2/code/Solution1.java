package q081_090.q085_2.code;

import java.util.Stack;

/**
 * 参考84算法
 * 把每一行看成以为数组，计算最大面积
 *
 */
public class Solution1 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            // 遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i <= n; ++i) {
            int curElement = (i == n) ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= curElement) {
                int high = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, high * width);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int resp = new Solution1().maximalRectangle(matrix);
        System.out.println(resp);
    }
}