package hashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

import javafx.util.Pair;
import linkedlist.LinkedList;
import sorting_algos.sortingAlgos;

public class hashFunctions {
	/*	Finds whether an array is a subset of another array	*/
	public boolean subsetArray(int[] arr1,int[] arr2){
		
		HashSet<Integer> set = new HashSet<Integer>();
		boolean flag = true;
		
		if(arr1.length >= arr2.length){
			for(int i = 0;i < arr1.length;i++)
				set.add(arr1[i]);
			for(int i = 0;i < arr2.length;i++){
				if(!set.contains(arr2[i])){
					flag = false;
					break;
				}
			}	
		}
		else{
			for(int i = 0;i < arr2.length;i++)
				set.add(arr2[i]);
			for(int i = 0;i < arr1.length;i++){
				if(!set.contains(arr1[i])){
					flag = false;
					break;
				}
			}		
		}
		return flag;
	}
	/*	Given an array A[] and a number x, check for pair in A[] with sum as x	*/
	public boolean pairSum(int[] arr,int sum){
		
		boolean flag = false;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0;i < arr.length;i++)
			set.add(arr[i]);
		
		for(int i = 0;i < arr.length;i++){
			if(set.contains(sum-arr[i]) && ((sum - arr[i]) != arr[i])){
				flag = true;
				break;
			}
			if(flag)
				break;
		}
		
		return flag;
	}
	/*	Check if a given array contains duplicate elements within 
	 * 	k distance from each other	*/
	public boolean duplicateAtK(int[] arr,int k){
		
		boolean flag = false;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0;i < arr.length;i++){
			
			if(!set.contains(arr[i])){
				set.add(arr[i]);
				if(i - k >= 0)
					set.remove(arr[i-k]);
		}
			else
				return true;
			}
		
		return flag;
	}
	/*	Given an array of pairs, find all symmetric pairs in it	*/
	public ArrayList<Pair<Integer,Integer>> returnSymmetricPairs(int[][] arr){
		
		ArrayList<Pair<Integer,Integer>> sym = new ArrayList<Pair<Integer,Integer>>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0;i < arr.length;i++)
			map.put(arr[i][0],arr[i][1]);
			
		for(int j = 0;j < arr.length;j++){
			if(map.containsKey(arr[j][1])){
				if(map.get(arr[j][1]) != null && map.get(arr[j][1]) == arr[j][0]){
					Pair<Integer,Integer> p = new Pair<Integer,Integer>(arr[j][0],arr[j][1]);
					sym.add(p);
				}	
			}
		}	
		return sym;
	}
	/*	Group multiple occurrence of array elements ordered by first occurrence	*/
	public int[] multipleOccurences(int[] arr){
		
		HashMap<Integer,Integer> elementCount = new LinkedHashMap<Integer,Integer>();
		int[] arr1 = new int[arr.length];
		
		for(int i = 0;i < arr.length;i++){
			
			if(elementCount.containsKey(arr[i])){
				int count = elementCount.get(arr[i]);
				count++;
				elementCount.put(arr[i], count);
			}
			else{
				elementCount.put(arr[i],1);
			}	
		}
		
		int index1 = 0;
		for(int i : elementCount.keySet()){
			int number = elementCount.get(i);
			
			for(int j = 0;j < number;j++){
				arr1[index1] = i;
				index1++;
			}
		}
		
		return arr1;
	}
	/*	How to check if two given sets are disjoint?	*/
	public boolean disjointSets(int[] arr1,int[] arr2){
		
		boolean flag = true;
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0;i < arr1.length;i++)
			set.add(arr1[i]);
		
		for(int i = 0;i < arr2.length;i++){
			if(set.contains(arr2[i])){
				return false;
			}
		}
		
		return flag;
		
	}
	/*	Pair with given product 	*/
	public boolean pairProduct(int[] arr,int prod){
		
		HashSet<Integer> set = new HashSet<Integer>();
		boolean flag = false;
		
		for(int i = 0;i < arr.length;i++){
			if(prod % arr[i] == 0)
				set.add(prod/arr[i]);
		}
		
		for(int i = 0;i < arr.length;i++){
			if(set.contains(arr[i]) && ((arr[i] * arr[i]) != prod))
				return true;
		}
		
		return flag;
	}
	/*	Find missing elements of a range	*/
	public ArrayList<Integer> missingElements(int[] arr){
		
		ArrayList<Integer> missing = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 0;i < arr.length;i++){
			set.add(arr[i]);
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		
		for(int i = min;i <= max;i++){
			if(!set.contains(i))
				missing.add(i);
		}
		return missing;
	}
	/*	Convert an array to reduced form	*/
	public int[] reducedForm(int[] arr){
		
		int[] reduced = new int[arr.length];
		int[] arr3 = new int[arr.length];
		
		for(int i = 0;i < arr.length;i++)
			arr3[i] = arr[i];
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		sortingAlgos sa = new sortingAlgos();
		int[] arr2 = sa.mergeSort(arr, 0, arr.length-1);
		
		for(int i = 0;i < arr2.length;i++)
			map.put(arr2[i], i);
		
		for(int i = 0;i < arr.length;i++){
			reduced[i] = map.get(arr3[i]);
		}
		
		return reduced;
		
	}
	/*	Find Itinerary from a given list of tickets	*/
	public void printItinerary(HashMap<String,String> data_set){
		
		ArrayList<String> to = new ArrayList<String>();
		ArrayList<String> from = new ArrayList<String>();
		ArrayList<String> path = new ArrayList<String>();
		
		for(String str : data_set.keySet()){
			from.add(str);
			to.add(data_set.get(str));
		}
		
		String start = null;
		for(String i : from){
			if(!to.contains(i))
				start = i;
		}
		if(start == null){
			System.out.println("Could not find start point");
			return;
		}
		String to_ = data_set.get(start);
		while(to_ != null){
			System.out.println(start + "->" + to_);
			start = to_;
			to_ = data_set.get(start);
		}
		
	}
	/*	Find number of Employees Under every Employee	*/
	public HashMap<String,Integer> managerEmployee(HashMap<String,String> dataSet){
		
		HashMap<String,ArrayList<String>> managerEmpl = new HashMap<String,ArrayList<String>>();
		ArrayList<String> managers = new ArrayList<String>();
		HashMap<String,Integer> noOfEmployees = new HashMap<String,Integer>();
		
		for(String i : dataSet.keySet()){
			ArrayList<String> al;
			if(managerEmpl.get(dataSet.get(i)) == null)
				al = new ArrayList<String>();
			else
				al = managerEmpl.get(dataSet.get(i));
			
			if(!i.equals(dataSet.get(i))){
			al.add(i);
			managerEmpl.put(dataSet.get(i), al);
			}
			if(!managers.contains(dataSet.get(i)))
				managers.add(dataSet.get(i));
		}
		
		for(String i : managerEmpl.keySet()){
			ArrayList<String> al = managerEmpl.get(i);
			ArrayList<String> addition = new ArrayList<String>();
			
			for(String j : al){
				if(managers.contains(j) && !j.equals(i))
					addition.addAll(managerEmpl.get(j));
			}
			al.addAll(addition);
			managerEmpl.put(i, al);
		}
		
		for(String i : managerEmpl.keySet()){
			noOfEmployees.put(i, managerEmpl.get(i).size());
		}
		
		for(String i : dataSet.keySet()){
			if(!managers.contains(i)){
				noOfEmployees.put(i, 0);
			}
		}
		
		return noOfEmployees;
	}
	/*	Count pairs with given sum	*/
	public void elementSum(int[] arr){
		
		HashMap<Integer,Pair<Integer,Integer>> sum = new HashMap<Integer,Pair<Integer,Integer>>();
		
		for(int i = 0;i < arr.length;i++){
			for(int j = 0;j < arr.length;j++){
			
				if(i != j){
					int s = arr[i] + arr[j];
					if(sum.get(s) == null){
						Pair<Integer,Integer> p = new Pair<Integer,Integer>(arr[i],arr[j]);
						sum.put(s, p);
					}
					else{
						if(sum.get(s).getKey() != arr[j] && sum.get(s).getValue() != arr[i]){
							System.out.println("Pairs found");
							System.out.print("(" + arr[i] + "," + arr[j] + ")");
							System.out.println("(" + sum.get(s).getKey() + "," + sum.get(s).getValue() + ")");
						return;
						}
					}
				}
				
			}
		}
		System.out.println("No pairs found");
		return;
		
	}
	/*	Check if an array can be divided into pairs whose sum is divisible by k	*/
	public boolean pairSumK(int[] arr,int k){
		
		boolean flag = true;
		int[] mod_arr = new int[arr.length];
		HashMap<Integer,Integer> mod_count = new HashMap<Integer,Integer>();
		
		for(int i = 0;i < arr.length;i++)
			mod_arr[i] = arr[i] % k;

		for(int i = 0;i < mod_arr.length;i++){
			if(mod_count.get(mod_arr[i]) == null)
				mod_count.put(mod_arr[i], 1);
			else{
				int count = mod_count.get(mod_arr[i]);
				count++;
				mod_count.put(mod_arr[i], count);
			}
		}
		for(int i : mod_count.keySet()){
			System.out.println(i + " " + mod_count.get(i));
		}
		
		for(int i : mod_count.keySet()){
			if(mod_count.get(k-i) == null)
				return false;
			else{
				if(mod_count.get(i) != mod_count.get(k-i))
					return false;
			}
		}
		
		return flag;
		
	}
	/*	Find the largest subarray with 0 sum	*/
	public int largestSubArray(int[] arr){
		
		HashMap<Integer,Integer> sums = new HashMap<Integer,Integer>();
		int sum,max_length;
		sum = max_length = 0;
		
		for(int i = 0;i < arr.length;i++){
		
			sum += arr[i];
			
			if(arr[i] == 0 && max_length == 0)
				max_length = 1;
			
			if(sum == 0)
				max_length = i + 1;
			
			Integer s = sums.get(sum);
			
			if(s != null)
				max_length = Math.max(max_length, i - s);
			else
				sums.put(sum, i);
		}
		
		return max_length;
	}
	/*	Longest Consecutive Subsequence	*/
	public int longestConsecutive(int[] arr){
		
		HashSet<Integer> set = new HashSet<Integer>();
		int max_length = 0;
		
		for(int i = 0;i < arr.length;i++)
			set.add(arr[i]);
		
		for(Integer i : set){
			int j = i;
			int length = 0;
			while(set.contains(j)){
				length++;
				j++;
				max_length = Math.max(length, max_length);
			}
		}
		
		return max_length;
	}

	public int contiguousElements(int[] arr){
		
		HashMap<Integer,ArrayList<Integer>> elements = new HashMap<Integer,ArrayList<Integer>>();
		int max_length = 0;
		
		for(int i = 0;i < arr.length;i++){
			ArrayList<Integer> al;
			al = elements.get(arr[i]);
			if(al == null){
				al = new ArrayList<Integer>();
				elements.put(arr[i], al);
			}
			else
				elements.get(arr[i]).add(i);
			}

		
		return max_length;
	}
}
