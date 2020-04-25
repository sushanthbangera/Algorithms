/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edgeverve;

/**
 *
 * @author Sushanth Bangera
 */
public class MaxDiffCounter {
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 5};
        System.out.println(getMaxDiff(arr));
        System.out.println(maxDifference(arr));
    }
    
    public static int getMaxDiff(int arr[]) {
        int len = arr.length;
        int maxDiff = Integer.MIN_VALUE;
        
        for(int i = 1; i < len; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    int diff = arr[i] - arr[j];
                    maxDiff = Math.max(maxDiff, diff);
                }
            }
        }
        return maxDiff;
    }
    //15 Basically you need to keep track of the minimum value found so far and the maximum diff found so far:
    static int maxDifference(int[] a) {
        int minimum, diff = -1;
        if (a.length == 0) {
            return -1;
        }
        minimum = a[0];
        for (int i = 1; i < a.length; i++) {
            diff = Math.max(diff, a[i] - minimum);
            minimum = Math.min(minimum, a[i]);
        }
        return diff;
    // depending on interpretation of requirements, above line might be wrong
        // Instead, use:
        // return diff > 0 ? diff : -1;
    }
}
