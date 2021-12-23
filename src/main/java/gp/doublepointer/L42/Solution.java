package gp.doublepointer.L42;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int sum = 0;
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        while (left < right) {
            if (leftHeight < rightHeight) {
                if (leftHeight > height[left + 1]) {
                    sum += leftHeight - height[left + 1];
                } else {
                    leftHeight = height[left + 1];
                }
                left++;
            } else {
                if (rightHeight > height[right - 1]) {
                    sum += rightHeight - height[right - 1];
                } else {
                    rightHeight = height[right - 1];
                }
                right--;
            }
        }
        return sum;
    }
}