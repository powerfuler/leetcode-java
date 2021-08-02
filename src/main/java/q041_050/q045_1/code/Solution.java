package q041_050.q045_1.code;

/**
 * * 时间复杂度：$O(n)$
 * * 空间复杂度：$O(n)$
 *
 */
public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j + nums[j] < i)
                j++;
            f[i] = f[j] + 1;
        }
        return f[n - 1];
    }

    public int jump1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            //遇到边界，就更新边界，并且步数加一
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public int jump2(int[] nums) {
        //要找的位置
        int position = nums.length - 1;
        int steps = 0;
        //是否到了第 0 个位置
        while (position != 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    //更新要找的位置
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}