package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Sushanth Bangera
 */
public class KthSmallestElement {

    public static int getKthSmallestElement(int arr[], int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int pos = partition(arr, l, r);
            if (pos - l == k - 1) {
                return arr[pos];
            }
            if (pos - l > k - 1) {
                return getKthSmallestElement(arr, l, pos - 1, k);
            }
            return getKthSmallestElement(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    }

    // Similar to quicksort technoque, last element is taken as pivot
    // and smaller elements are moved left of it and greater elements are 
    // moved right of it
    private static int partition(int arr[], int l, int r) {
        int pivot = arr[r];
        int i = l;
        for (int j = l; j < r - 1; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int arr[] = {1, 3, 6, 10, 4, 5, 25};
//        System.out.println(getKthSmallestElement(arr, 0, arr.length - 1, 3));
        
        String s = "ba";
       // s = s.replaceAll(" ", "");
        int len = s.length();
        List<String> cList = new ArrayList<>();
        
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                String sub = s.substring(i, j);
                if(sub.trim().length() > 0) {
                    cList.add(sub);
                }
             
            }
        }
        
        Collections.sort(cList);
        for(String str : cList) {
            System.out.println(str);
        }
        
        
    }

}
