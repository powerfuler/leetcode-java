package gp.binarysearch;

class Solution {
    public int search(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (num[mid] > num[start]) {
                if (target <= num[mid] && num[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= num[mid] && target <= num[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (num[start] == target) {
            return start;
        }
        if (num[end] == target) {
            return end;
        }
        return -1;
    }
}