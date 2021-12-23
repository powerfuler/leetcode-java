package gp.doublepointer.L167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int start = 0, end = numbers.length - 1;
        int[] result = {-1, -1};
        while (start < end) {
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
        }
        return result;
    }
}