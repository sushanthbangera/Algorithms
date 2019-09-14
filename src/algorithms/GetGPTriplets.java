/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sushanth Bangera
 */
public class GetGPTriplets {

    public static void main(String[] args) {
        int r = 3;
        Integer arr[] = {1, 3, 9, 9, 27, 36};
        
        System.out.println(getTripletsCount(Arrays.asList(arr), r) + "Triplets Count : ");
        //return count;
    }
    
    public static long getTripletsCount(List<Integer> arr, int r) {
        Map<Integer, Integer> tripletMap = new HashMap<>();
	Map<Integer, Integer> t3 = new HashMap<>();
	int result = 0;
        
	for(Integer a : arr) {
		result += t3.getOrDefault(a, 0);
		if (tripletMap.containsKey(a)){
			t3.put(a*r, t3.getOrDefault(a*r, 0) + tripletMap.get(a));
		}
		tripletMap.put(a*r, tripletMap.getOrDefault(a*r, 0) + 1);
	}
        return result;
    }
}
