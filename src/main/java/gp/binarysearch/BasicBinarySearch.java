package gp.binarysearch;

public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] num = {1, 4, 7, 9, 10, 14, 16, 20, 56, 89};
        System.out.println(new BasicBinarySearch().getIndex(num, 5));
    }

    public int getIndex(int[] num, int target) {
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
            } else if (num[mid] > target) {
                end = mid;
            } else {
                start = mid;
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
