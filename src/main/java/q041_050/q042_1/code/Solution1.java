package q041_050.q042_1.code;

/**
 *
 *
 */
public class Solution1 {

    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                result += leftMax - height[left] > 0 ?
                        leftMax - height[left] : 0;
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                result += rightMax - height[right] > 0 ?
                        rightMax - height[right] : 0;
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }
}