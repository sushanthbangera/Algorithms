/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Sushanth Bangera
 */
public class FirstDuplicate {
     
    public static void main(String[] args) {
        
        int arr[] = {1, 5, 6, 4, 2, 3};
        int len = arr.length;
        int firstDuplicate = getFirstDuplicate(arr, len);   
        if(firstDuplicate != -1) {
            System.out.println("First Duplicate is " + firstDuplicate);
        } else {
            System.out.println("No Duplicate elements");
        }
    }
    
    public static int getFirstDuplicate(int arr[], int n) {
        int map[] = new int[10];
        
        for(int i = 0; i < n; i++) {
            int val = map[arr[i]];
            if(val == 1) {
                return arr[i];
            } else {
                map[arr[i]] = 1;
            }
        }
        return -1;
    }
}
