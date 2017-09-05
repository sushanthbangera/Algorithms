/*
Program to search the index of element in a rotated array
*/

package algorithms;

/**
 *
 * @author Sushanth Bangera
 */
public class RotatedArraySearch {

    public static int getIndexofElement(int arr[], int left, int right, int element) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        
        if(arr[mid] == element) {
            return mid;
        }

        // if the array is sorted from left to mid
        if (arr[left] <= arr[mid]) {
            if (element >= arr[left] && element <= arr[mid]) {
                return getIndexofElement(arr, left, mid - 1, element);
            }
            return getIndexofElement(arr, mid + 1, right, element);
        }
        
        // if the array is sorted from mid to right
        if(element >= arr[mid] && element <= arr[right]) {
            return getIndexofElement(arr, mid + 1, right, element);
        }
        return getIndexofElement(arr, left, mid - 1, element);
    }
    
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(getIndexofElement(arr, 0, arr.length - 1, 10));
        
        int arr2[] = {7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(getIndexofElement(arr2, 0, arr2.length - 1, 8));
    }
}
