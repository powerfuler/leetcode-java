package gp.sort;

public class InsertSort {

    public static void insertSort(int[] array) {
        int insertNode;
        int j;
        for (int i = 1; i < array.length; i++) {
            insertNode = array[i];
            j = i - 1;
            while (j >= 0 && insertNode < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNode;
        }
    }
}
