/*
 * Given an array of n elements and an integer m, 
 * we need to write a program to find the number of contiguous subarrays 
 * in the array which contains exactly m odd numbers.

input: {1, 2, 3, 4} output: [1], [2], [3], [4], [1,2], [2,3] [3,4], [2,3,4]
 */
package algorithms.arrays;

/**
 *
 * @author Sushanth Bangera
 */
public class EvenSubArray {
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int m = 1; //odd elements allowed
        // [1], [2], [3], [4], [1,2], [2,3] [3,4], [2,3,4]
        System.out.println("Sub Array: " + getTotalEvenSubArray(arr, 1));
        
    }
    
    private static int getTotalEvenSubArray(int arr[], int m) {
        int len = arr.length;
        int count = 0;
        int prefix[] = new int[len];
        int odd = 0;
        
        for(int i = 0; i < len; i++) {
            prefix[odd]++;
            
            if((arr[i] & 1) == 1) {
                odd++;
            }
            
            if(odd >= m) {
                count += prefix[odd - m];
            }
           
        }
        return count;
    }
}
