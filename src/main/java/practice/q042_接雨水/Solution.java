package practice.q042_接雨水;

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                if (leftMax > height[left + 1]) {
                    sum += leftMax - height[left + 1];
                } else {
                    leftMax = height[left + 1];
                }
                left ++;
            } else {
                if (rightMax > height[right - 1]) {
                    sum += rightMax - height[right - 1];
                } else {
                    rightMax = height[right - 1];
                }
                right --;
            }
        }
        return sum;
    }
}
