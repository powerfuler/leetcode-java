package q081_090.q084_2.code;

/**
 * 暴力解法
 * 易理解，效率低，超时
 */
public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int result = 0;

        for (int i = 0; i < n; ++i) {
            int curMin = heights[i];

            for (int j = i; j < n; ++j) {
                curMin = Math.min(curMin, heights[j]);
                result = Math.max(result, (j - i + 1) * curMin);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 5, 6, 2, 3};
        int resp = new Solution1().largestRectangleArea(a);
        System.out.println(resp);
    }
}