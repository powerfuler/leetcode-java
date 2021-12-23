package gp.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        //quick sort
        long start4 = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < array.length; j++) {
                array[j] = (int) (Math.random() * 10000);
            }
            quickSort(array);
        }
        long end4 = System.currentTimeMillis();
        System.out.println("quick Sort->");
        System.out.println(end4 - start4);
    }

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        sort(array, start, right);
        sort(array, left, end);
    }
}
