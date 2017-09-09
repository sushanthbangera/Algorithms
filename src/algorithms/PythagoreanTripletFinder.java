/*
Pythagorean Triplet in an array
Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2
*/
package algorithms;

import java.util.Arrays;

/**
 *
 * @author Sushanth Bangera
 */
public class PythagoreanTripletFinder {
    
    public static boolean isPythagoreanTripletExists(int arr[]) {
        int arrLen = arr.length;
        
        // Store the squares of the values in their respective index
        for(int i = 0; i < arrLen; i++) {
            arr[i] = arr[i] * arr[i];
        }
        // Sort the array 
        Arrays.sort(arr);
        
        // The last element is considered as a and (b, c) pair is searched
        // in the sub array
        for(int i = arrLen - 1; i >= 2; i--) {
            int l = 0;// first element 
            int r = i - 1; // last element of sub array arr[0....i-1]
            while (l < r) {
                // If triplet found return true
                if(arr[l] + arr[r] == arr[i]) {
                    return true;
                }
                // Else keep decreasing the sub array by moving 'l' or 'r'
                if (arr[l] + arr[r] > arr[i]) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return false;
    }
    
   
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5};
        System.out.println(isPythagoreanTripletExists(arr) ? "Yes" : "No");
    }
}
