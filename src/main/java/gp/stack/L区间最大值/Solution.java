package gp.stack.L区间最大值;

// 给定一个数组  求出截取出来的和和当前最小值的乘积结果的最大值

import java.util.Stack;

class Solution {
    public int getMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        //求前缀和数组
        int[] sum = new int[numbers.length + 1];
        for (int i = 1; i <= numbers.length; i++) {
            sum[i] = sum[i - 1] + numbers[i - 1];
        }
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] < numbers[stack.peek()]) {
                int index = stack.pop();
                int left = i;
                int right = i;
                if (stack.isEmpty()) {
                    left = 0;
                } else {
                    left = index;
                }
                //用 O（1）取到前缀和
                max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = numbers.length;
            int right = numbers.length;
            if (stack.isEmpty()) {
                left = 0;
            } else {
                left = index;
            }
            max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] number = new int[]{6, 5, 2, 18, 19};
//        int[] number = new int[]{5, 2, 3, 4, 1};// 28
        System.out.println(new Solution().getMax(number));
    }
}