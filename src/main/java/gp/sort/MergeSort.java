package gp.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[100000];
        //merge sort
        long start5 = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < array.length; j++) {
                array[j] = (int) (Math.random() * 10000);
            }
            mergeSort(array);
        }
        long end5 = System.currentTimeMillis();
        System.out.println("merge Sort->");
        System.out.println(end5 - start5);

    }

    //merge Sort
    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSortImpl(array, 0, array.length - 1, temp);
    }

    public static void mergeSortImpl(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortImpl(array, start, mid, temp);
        mergeSortImpl(array, mid + 1, end, temp);
        merge(array, start, mid, end, temp);
    }

    public static void merge(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        for (index = start; index <= end; index++) {
            array[index] = temp[index];
        }
    }
}
