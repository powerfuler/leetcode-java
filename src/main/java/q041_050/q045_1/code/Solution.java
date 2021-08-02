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
}