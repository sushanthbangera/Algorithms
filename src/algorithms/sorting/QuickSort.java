/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sorting;

/**
 *
 * @author Sushanth Bangera
 */
public class QuickSort {
    
    public static void main(String[] args) {
        
        int arr[] = {13, 46, 78, 22, 10};
        quicksort(arr);
        utils.Utility.printArray(arr);
    }
    
    public static void quicksort(int arr[]) {
        quicksort(arr, 0, arr.length);
    }
     
    private static void quicksort(int arr[], int low, int high) {
        
        if(low < high) {
            int pivot = partition(arr, low, high);
            
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }
    
    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for(int j = low; j < high; j++) {
            
            if(arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
