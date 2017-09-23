/*
Given an array of integers where each element represents the max number of steps 
that can be made forward from that element. Write a function to return the minimum
number of jumps to reach the end of the array (starting from the first element). 
If an element is 0, then cannot move through that element.
 */
package algorithms.arrays;

/**
 *
 * @author Sushanth Bangera
 */
public class MinimumJumps {
    
    public static int getMinimumJumps(int arr[]) {
        
        int len = arr.length;
        if(len <= 1) {
            return 0;
        }
        if(arr[0] == 0) {
            return -1;
        }
        
        int jumpCount = 1;
        int maxLeap = arr[0];
        int step = arr[0];
        
        for(int i = 1; i < len; i++) {
            // If end of the array is reached return jumpCount
            if(i == len - 1) {
                return jumpCount;
            }
            //max index which can be jumped
            maxLeap = Math.max(maxLeap, i + arr[i]);
            step--;
            
            if(step == 0) {
                jumpCount++;
                // if the current index is greater than the maxLeap possible
                if(i >= maxLeap) {
                    return -1;
                }
                //Reset the step to number of steps needed to maxLeap from i
                step = maxLeap - i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int arr[] = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
 
        System.out.println(getMinimumJumps(arr));
    }
}
