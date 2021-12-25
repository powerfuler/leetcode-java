package gp.sort.L912;

class SortEx {
	
	public static void main(String[] args) {
		int[] array = new int[100000];
		
		// bubble Sort 
		long start1 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			bubbleSort(array);
		}
		long end1 = System.currentTimeMillis();	
		System.out.println("Bubble Sort->");
		System.out.println(end1 - start1);
		//insert Sort
		long start2 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			insertSort(array);
		}
		long end2 = System.currentTimeMillis();	
		System.out.println("Insert Sort->");
		System.out.println(end2 - start2);
		//select sort
		long start3 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			selectSort(array);
		}
		long end3 = System.currentTimeMillis();	
		System.out.println("Select Sort->");
		System.out.println(end3 - start3);
		
		//quick sort
		long start4 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			quickSort(array);
		}
		long end4 = System.currentTimeMillis();	
		System.out.println("quick Sort->");
		System.out.println(end4 - start4);
		//merge sort
		long start5 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			mergeSort(array);
		}
		long end5 = System.currentTimeMillis();	
		System.out.println("merge Sort->");
		System.out.println(end5 - start5);
		
	}
	public static void bubbleSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < length; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static void insertSort(int[] array) {
		int insertNode;
		int j;
		for (int i = 1; i < array.length; i++) {
			insertNode = array[i];
			j = i - 1;
			while(j >= 0 && insertNode < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = insertNode;
		}
	}
	
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int pos = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[pos] > array[j]) {
					pos = j;
				}
			}
			if (pos != i) {
				int temp = array[i];
				array[i] = array[pos];
				array[pos] = temp;
			}
		}
	}
	//quick sort
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
			array[index]= temp[index];
		}
	}
}
