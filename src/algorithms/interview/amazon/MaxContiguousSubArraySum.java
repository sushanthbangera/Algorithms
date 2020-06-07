/*
 * Find the maximum Contiguous sub Array Sum
 */
package algorithms.interview.amazon;

/**
 *
 * @author Sushanth Bangera
 */
public class MaxContiguousSubArraySum {
    
    /*
     Kadanes's Algorithm
     time complexity : O(n)
    */
    public static int getMaxContiguousSubArraySum(int arr[]) {
        int len = arr.length;
        int maxSum = arr[0];
        int currentSum = maxSum;
        
        for (int i = 0; i < len; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
   
    /*
     time complexity : O(n^2)
    */
    public static int getMaxContiguousSubArraySumBruteForce(int arr[]) {
        int maxSum = 0;
        int len = arr.length;
        
        for (int i = 0; i < len; i++) {
            int currentSum = arr[i];
            for (int j = i + 1; j < len; j++) {
                currentSum += arr[j];
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;    
    }
    
    
    public static void main(String[] args) {
        
        int arr[] = {-2, 5, 2, -4, 2, 1};
        System.out.println("Max Sub Array Sum : " + MaxContiguousSubArraySum.getMaxContiguousSubArraySum(arr));
        System.out.println("Max Sub Array Sum : " + MaxContiguousSubArraySum.getMaxContiguousSubArraySumBruteForce(arr));
    }
}
