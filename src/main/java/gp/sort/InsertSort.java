package gp.sort;

public class InsertSort {

    public static void insertSort(int[] array) {
        if(array == null|| array.length==0)return;
        int insertNode;
        for(int i = 1; i<array.length;i++){
            insertNode = array[i];
            int j = i-1;
            while (j>=0){
                if(insertNode< array[j]){
                    array[j+1] = array[j];
                    array[j] = insertNode;
                } else {
                    break;
                }
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int j = 0; j < array.length; j++) {
            array[j] = (int) (Math.random() * 10000);
        }
        insertSort(array);
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }
}
