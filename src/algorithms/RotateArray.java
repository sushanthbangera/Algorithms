
package algorithms;

import utils.Utility;

/**
 *
 * @author Sushanth Bangera
 */
public class RotateArray {
    
    public void rotateLeft(int arr[], int d) {
        int len = arr.length, temp, i, j, k;
        // Breaking the array into diiferent sections and shifting the elements
        for(i = 0; i < gcd(d, len); i++) {
            temp = arr[i];
            j = i;
            while(1 !=0) {
                k = j + d;
                if(k >= len) {
                    k = k - len;
                }
                if(k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
    
    // Method to find the gcd of two numbers
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
    
    public static void main(String[] args) {
        RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotateLeft(arr, 2);
        Utility.printArray(arr);
    }
    
}
