package gp.sort;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0) return;
        int length = array.length;
        int end = length;
        for (int i = 0; i < length; i++) {
            int start = 1;
            while (start < end) {
                if (array[start] < array[start - 1]) {
                    int tem = array[start - 1];
                    array[start - 1] = array[start];
                    array[start] = tem;
                }
                start++;
            }
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int j = 0; j < array.length; j++) {
            array[j] = (int) (Math.random() * 10000);
        }
        bubbleSort(array);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }
}
