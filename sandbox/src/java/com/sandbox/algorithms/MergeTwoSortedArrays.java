//package com.sandbox.algorithms;

/**
 * Given two sorted arrays, merge them 
 * into a single sorted array
 *
 * @author Francisco Franco
 */

public class MergeTwoSortedArrays {

	/**
	 * @param myArray
	 */
	private void printArray(String description, int[] myArray) {
		System.out.print(description);
		for (int l = 0; l < myArray.length; l++) {
			System.out.print(myArray[l] + " ");
		}
		System.out.println("");
	}

	/**
	 * Worst Time Complexity: O(n1 + n2) 
	 * where n1 = a.length and n2 = b.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] merge(int a[], int b[]) {
		int[] sorted = new int[a.length + b.length];
		int aIndex = a.length - 1;
		int bIndex = b.length - 1;
		int sIndex = sorted.length - 1;
		while (aIndex >= 0 && bIndex >= 0) {
			// System.out.println("aIndex is: " + aIndex);
			// System.out.println("bIndex is: " + bIndex);
			// System.out.println("sIndex is: " + sIndex);
			if (a[aIndex] > b[bIndex]) {
				sorted[sIndex--] = a[aIndex--];
			} else {
				sorted[sIndex--] = b[bIndex--];
			}
		}

		// Means went through entire array b then
		// look at remaining elements in a
		while (aIndex >= 0) {
			sorted[sIndex--] = a[aIndex--];
		}

		// Means went through entire array a then
		// look at remaining elements in b
		while (bIndex >= 0) {
			sorted[sIndex--] = b[bIndex--];
		}
		return sorted;
	}

	/**
	 * Worst Time Complexity: O(n1 + n2) 
	 * where n1 = a.length and n2 = b.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] merge2(int a[], int b[]) {
		int[] sorted = new int[a.length + b.length];
		int aIndex = 0;
		int bIndex = 0;
		int sIndex = 0;
		while (aIndex < a.length && bIndex < b.length) {
			// System.out.println("aIndex is: " + aIndex);
			// System.out.println("bIndex is: " + bIndex);
			// System.out.println("sIndex is: " + sIndex);
			if (a[aIndex] < b[bIndex]) {
				sorted[sIndex++] = a[aIndex++];
			} else {
				sorted[sIndex++] = b[bIndex++];
			}
		}

		// Store remaining elements in a into sorted array
		while (aIndex < a.length) {
			sorted[sIndex++] = a[aIndex++];
		}

		// Store remaining elements in b into sorted array
		while (bIndex < b.length) {
			sorted[sIndex++] = a[aIndex++];
		}
		return sorted;
	}
	
	/**
	 * Worst Time Complexity: O(n1 + n2) 
	 * where n1 = a.length and n2 = b.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] merge3(int[] a, int[] b) {
		// Index for array a
		int i = 0;
		// Index for arry b
		int j = 0;
		// Index for array m
		int k = 0;
		// Merged array
		int[] m = new int[a.length + b.length];
		while (i < a.length && j < b.length) {
	    if (a[i] < b[j]) {
				m[k] = a[i];
				i++;
				k++;
	    }
	    else { 
				m[k] = b[j];
				j++;
				k++;
	    }
		}
		
		// If array a was larger than array b
		// copy remaing sorted elements from a 
		// into array m
		while (i < a.length) {
	    m[k] = a[i];
	    i++;
	    k++;
		}
		
		// If array b was larger than array a
		// copy remaining sorted elements from b
		// into array m
		while (j < b.length) {
	    m[k] = b[j];
	    j++;
	    k++;
		}
		return m;
	}
	
	/**
	 * Worst Time Complexity: O(n1) 
	 * where n1 = merged.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] merge4(int[] a, int[] b) {
		int[] merged = new int[a.length + b.length];
		int aIndex = 0;
		int bIndex = 0;
		for (int i = 0; i < merged.length; i++) {
			if  (aIndex < a.length && bIndex < b.length && a[aIndex] > b[bIndex]) {
				merged[i] = b[bIndex];
				bIndex++;
			}
			else if (aIndex < a.length) {
				merged[i] = a[aIndex];
				aIndex++;
			}
			else if (bIndex < b.length) {
				merged[i] = b[bIndex];
				bIndex++;
			}
		}
		return merged;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] a = {11, 22, 33, 44};
		// int[] b = {37, 48, 59, 100};
		int[] a = { 1, 3, 7, 9 };
		int[] b = { 2, 4, 6, 8 };
		MergeTwoSortedArrays mtsa = new MergeTwoSortedArrays();
		mtsa.printArray("Array a: ", a);
		mtsa.printArray("Array b: ", b);
		int[] merged = mtsa.merge4(a, b);
		mtsa.printArray("Merged: ", merged);
	}
}
