/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.arrays;

/**
 *
 * @author Sushanth Bangera
 */
public class WavwFormSort {
    
    public static void main(String[] args) {
        int arr[] = {10, 25, 2, 5, 6, 40};
        waveSort(arr);
        utils.Utility.printArray(arr);
    }
    
    public static void waveSort(int arr[]) {
        int n = arr.length;
        
        for(int i = 0; i < n; i+=2) {
            
            if(i > 0 && arr[i - 1] > arr[i]) {
                swap(arr, i - 1, i);
            }
            
            if(i < n && arr[i + 1] > arr[i]) {
                swap(arr, i, i + 1);
            }
        }
    }
    
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
        
