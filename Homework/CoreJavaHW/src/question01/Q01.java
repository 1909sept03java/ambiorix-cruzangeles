package question01;

/*
 * Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4 
 */

public class Q01 {

	public static void main(String[] args) {
		int[] arr1 = {1,0,5,6,3,2,3,7,9,8,4};
		for(int i = 0; i < arr1.length; i++) System.out.print(arr1[i] + " ");
		System.out.println();
		int[] arr2 = bubbleSort(arr1);
		for(int i = 0; i < arr2.length; i++) System.out.print(arr2[i] + " ");
	}
	
	static int[] bubbleSort(int[] arr) {
		//System.out.println("SORTING-");
		for(int j = 0; j < arr.length; j++) {
			for(int i = 0; i < arr.length-1; i++) {
				if(arr[i] < arr[i+1]) {
					continue;
				}
				else {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		return arr;
	}
	
}
