package project2;

import java.util.ArrayList;
import java.util.List;

public class MyNK {
	
	
	static List<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
	
	
	// Brute force method- Extremely slow with larger input sizes since we're adding so many combinations to the ArrayList, then deleting them.
    public static void helper(int arr[], int data[], int start, int end, int index, int k) {
    	
        if (index == k) {
        	ArrayList<Integer> combo = new ArrayList<Integer>();
            for (int j=0; j<k; j++) {
            	combo.add(data[j]);
            }
            // makes sure combination doesn't already exist 
            if (combinations.indexOf(combo) >= 0) {
            	return;
            }
            combinations.add(combo);
            return;
        }
        for (int i=start; i<=end && end-i+1 >= k-index-2; i++) {
            data[index] = arr[i];
            helper(arr, data, i+1, end, index+1, k);
            helper(arr, data, i, end, index+1, k);
        }
    }

    public static void nk_combinations(int arr[], int n, int k) {
        int data[]=new int[k];
        helper(arr, data, 0, n-1, 0, k);
        
    }
 
    public static void main (String[] args) {
        if (args.length < 3) {
        	System.out.println("Enter N and K as cmd arguments.");
        	
        }
        System.out.println(args.length);
        int k = 9;
        int n = 9;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = i+1;
        }
        
        
        nk_combinations(arr, n, k);
        remove_dupes(n);
        for(ArrayList<Integer> list: combinations) {
        	System.out.println(list);
        }
        System.out.println(combinations.size());
        
    }
    
    public static void remove_dupes(int n) {
    	
    	for(int i = 0; i < combinations.size(); i++) {
    		int[] counts = new int[n];
    		boolean valid = true;
    		for(int num: combinations.get(i)) {
    				counts[num-1]++;	
    				
    		}
    		for(int j = 0; j < counts.length; j++) {		
    			if (counts[j] > 2) {
    				valid = false;
    			}
    		}
    		
    		if (!valid) {
    			combinations.remove(combinations.get(i));
    			i -= 1;
    		}
    	}  
    }
}
