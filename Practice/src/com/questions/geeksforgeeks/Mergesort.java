package com.questions.geeksforgeeks;

public class Mergesort {
	public static void main(String a[]) {
		int i;
		int array[] = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0 };
		System.out.println("\n\n RoseIndia\n\n");
		System.out.println(" Selection Sort\n\n");
		System.out.println("Values Before the sort:\n");
		for (i = 0; i < array.length; i++)
			System.out.print(array[i] + "  ");
		System.out.println();
		mergeSort_srt(array, 0, array.length - 1);
		System.out.print("Values after the sort:\n");
		for (i = 0; i < array.length; i++)
			System.out.print(array[i] + "  ");
		System.out.println();
		System.out.println("PAUSE");
	}

	public static void mergeSort_srt(int array[], int lo, int n) {
		int low = lo;
		int high = n;
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		mergeSort_srt(array, low, middle);
		mergeSort_srt(array, middle + 1, high);
		
		System.out.println(array[low]+"\t"+array[high]);
		int end_low = middle;
		int start_high = middle + 1;
		while ((lo <= end_low) && (start_high <= high)) {
			if (array[low] < array[start_high]) {
				low++;
			} else {
				int Temp = array[start_high];
				for (int k = start_high - 1; k >= low; k--) {
					array[k + 1] = array[k];
				}
				array[low] = Temp;
				low++;
				end_low++;
				start_high++;
			}
		}
	}
}