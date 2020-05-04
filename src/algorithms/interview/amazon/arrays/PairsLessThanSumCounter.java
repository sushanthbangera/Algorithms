/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interview.amazon.arrays;

/**
 * Given an array in ascending order find the no of pairs whose sum is less than "X"
 * @author Sushanth Bangera
 */
public class PairsLessThanSumCounter {
    
    public static void main(String[] args) {
        
        int arr[] = {2, 4, 6, 9, 11};
        
        int X = 14;
        System.out.println(countPairs(arr, X));
        
        X = 13;
        System.out.println(countPairs(arr, X));
    }
    
    public static int countPairs(int arr[], int sum) {
        int len = arr.length;
        int pairCount = 0;
        int i = 0, j = len - 1;
        while (i != j) {
            if (arr[i] + arr[j] < sum) {
                pairCount = pairCount + (j - i);
                i++;
            } else {
                j--;
            }
        }
        return pairCount;
    } 
}
