
package algorithms;

/**
 *
 * @author Sushanth Bangera
 */
public class SecondLargestFinder {
     
    
    public static int getSecondLargest(int arr[]) {
        int largest = arr[0], secondLargest = Integer.MIN_VALUE;
        int len = arr.length;
        
        for(int i = 1; i < len; i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
