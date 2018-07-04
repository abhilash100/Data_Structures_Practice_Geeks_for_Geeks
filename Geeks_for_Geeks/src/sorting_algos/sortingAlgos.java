package sorting_algos;

import java.util.ArrayList;
import java.util.Collections;

public class sortingAlgos {

	/*	Prints the array given as argument*/
	public void printArray(int[] arr){
		
		for(int i = 0;i < arr.length;i++)
			System.out.print(arr[i] + " ");

		System.out.println();
		
	}
	
	/*	Generates a random arrar of size n and populates it 
	  	with integers between 0 and (n-1) in random order
	 */
	public int[] generateRandomArray(int n){
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0;i < n;i++){
			al.add(i);
		}
		Collections.shuffle(al);
		
		int[] arr = new int[n];
		for(int i = 0;i < al.size();i++){
			arr[i] = al.get(i);
		}
		return arr;
	}
	
	/*Implementation of selection sort algorithm*/
	public int[] selectionSort(int[] arr){
		
		for(int i = 0;i < arr.length;i++){
			int min = arr[i];
			int minIndex = i;
			for(int j = i + 1;j < arr.length;j++){
				if(arr[j] < min){
					minIndex = j;
					min = arr[j];
				}
			}
			if(minIndex != i){
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}

		return arr;
	}
	
	/*Implementation of bubble sort algorithm*/
	public int[] bubbleSort(int[] arr){
		
		for(int i = 0;i < arr.length - 2;i++){
			for(int j = i;j < arr.length - 1;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	/* Implementation of insertion sort algorithm */
	public int[] insertionSort(int[] arr){
		
		for(int i = 1;i < arr.length;i++){
			int j = i;
			int value = arr[i];
			while(j > 0 && value < arr[j-1]){
				arr[j] = arr[j-1];
				j = j - 1;
			}
			arr[j] = value;
		}
		return arr;
	}

	/* Used in the merge sort algorithm.
	 * Merges two sorted arrays into a single sorted array*/
	public int[] merge(int[] arr, int l,int m,int r){
		
		int size1 = m - l + 1;
		int size2 = r - m;
		
		int[] left = new int[size1];
		int[] right = new int[size2];
		
		for(int i = 0;i < size1;i++){
			left[i] = arr[l+i];
		}
		for(int j = 0;j < size2;j++){
			right[j] = arr[m+1+j];
		}
		
		int i,j,k;
		i = j = 0;
		k = l;
		
		while(i < size1 && j < size2){	
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			}
			else if(left[i] > right[j]){
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < size1){
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j < size2){
			arr[k] = right[j];
			j++;
			k++;
		}
		return arr;
	}

	/* Implementation of merge sort algorithm */
	public int[] mergeSort(int[] arr,int l,int r){
		
		if(l < r){
			int m = (l + r)/2;
			
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			
			return merge(arr,l,m,r);
		}
		else 
			return null;
	}

	/* Partitions the array taking last element as pivot */
	public int partition(int[] arr,int start,int end){
		
		int pivot = arr[end];
		int pIndex = start;
		
		for(int i = start;i <= end - 1;i++){
			if(pivot >= arr[i]){
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = temp;
		
		return pIndex;
	}
	/* Quick sort algorithm implementation */
	public int[] quickSort(int[] arr,int start,int end){
		if(start < end){
			int pIndex = partition(arr,start,end);
			quickSort(arr,start,pIndex-1);
			quickSort(arr,pIndex+1,end);
		}
		
		return arr;
	}
	
}
