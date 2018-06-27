package string_algos;

import java.util.HashSet;

public class stringAlgos {

	public void naivePatternSearch(String pattern,String str){
		
		if(pattern.length() > str.length()){
			System.out.println("Pattern size is greater than the string length");
			return;
		}
		int n = str.length();
		int p = pattern.length();
		HashSet<Integer> index = new HashSet<Integer>();
		
		for(int i = 0;i < n - p;i++){
			boolean flag = true;
			for(int j = 0;j < p;j++){
				//System.out.println((str.charAt(j) + " " + pattern.charAt(j - i)) + " " + i);
				if(str.charAt(j + i) != pattern.charAt(j)){
					flag = false;
					break;
				}
				if(!flag)
					break;
			}
			if(flag)
				index.add(i);	
		}
		
		if(!index.isEmpty()){
			System.out.println("Pattern found at : ");
			for(int i : index)
				System.out.print(i + " ");
		}
		else
			System.out.println("Pattern not found");
		return;
	}

	public int[] getLps(String pattern){
		
		int[] lps = new int[pattern.length()];
		
		lps[0] = 0;
		int j = 0;
		int i = 1;
		while(i < pattern.length()){
			if(pattern.charAt(i) == pattern.charAt(j)){
				j++;
				lps[i] = j;
				i++;
			}
			else {
				if(j != 0){
					j = lps[j-1];
			}
				else{
					lps[i] = 0;
					i++;
			}
		}
		}
		
		return lps;
	}

	public void kmpSearch(String pattern,String str){
		
		if(pattern.length() > str.length()){
			System.out.println("Pattern size is greater than the string length");
			return;
		}
		HashSet<Integer> index = new HashSet<Integer>();
		
		int[] lps = getLps(pattern);
		
		int i,j;
		i = j = 0;
		while(i < str.length()){
			if(pattern.charAt(j) == str.charAt(i)){
				i++;
				j++;
			
			if(j == pattern.length()){
				index.add((i-j));
				j = lps[j-1];
			}
			}
			else if(i < (str.length())){
				if(j != 0)
					j = lps[j-1];
				else
					i++;
			}
			
		}
		if(!index.isEmpty()){
			System.out.println("Pattern found at : ");
			for(int k : index)
				System.out.print(k + " ");
		}
		else
			System.out.println("Pattern not found");
		return;
	}

	public void rubinKarpSearch(String pattern,String str){
		
		if(pattern.length() > str.length()){
			System.out.println("Pattern size is greater than the string length");
			return;
		}
		
		int pat_hash = pattern.hashCode();
		HashSet<Integer> index = new HashSet<Integer>();
		
		for(int i = 0;i < str.length() - pattern.length();i++){
			int substr_hash = str.substring(i,pattern.length()+i).hashCode();
			if(substr_hash == pat_hash){
				if(str.substring(i,pattern.length()+i).equals(pattern))
					index.add(i);
			}
		}
		
		if(!index.isEmpty()){
			System.out.println("Pattern found at : ");
			for(int k : index)
				System.out.print(k + " ");
		}
		else
			System.out.println("Pattern not found");
		return;	
		
	}

	public void zSearch(String pattern,String str){
		
		if(pattern.length() > str.length()){
			System.out.println("Pattern size is greater than the string length");
			return;
		}
		
		StringBuffer z_string = new StringBuffer();
		int[] z_array = new int[pattern.length()+str.length()+1]; 
		HashSet<Integer> index = new HashSet<Integer>();
		
		for(int i = 0;i < pattern.length();i++)
			z_string.append(pattern.charAt(i));
		z_string.append('$');
		
		for(int i = 0;i < str.length();i++)
			z_string.append(str.charAt(i));
		
		int i,j;
		z_array[0] = 0;
		i = 1;
		
		while(i < z_string.length()){
			j = 0;
			int k = i;
			while(k < z_string.length() && z_string.charAt(k) == z_string.charAt(j)){
				k++;
				j++;
			}
			z_array[i] = j;
			i++;
		}
		
		for(int l = 0;l < z_array.length;l++){
			if(z_array[l] == pattern.length())
				index.add(l - pattern.length() - 1);
		}		
		
		if(!index.isEmpty()){
			System.out.println("Pattern found at : ");
			for(int k : index)
				System.out.print(k + " ");
		}
		else
			System.out.println("Pattern not found");
		return;	
	}
}
