/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interview.amazon;

/**
 *
 * @author Sushanth Bangera
 */
public class LocksAndKeys {

    public static void matchPairs(int[] locks, int[] keys, int low, int high) {

        if (low < high) {
            
            int pivot = partition(locks, low, high, keys[high]);
            partition(keys, low, high, locks[pivot]);
            
            matchPairs(locks, keys, low, pivot - 1);
            matchPairs(locks, keys, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high, int pivot) {

        int i = low;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                swap(i, j, arr);
                i++;
            } else if (arr[j] == pivot) {
                swap(j, high, arr);
                j--;
            }
        }
        swap(i, high, arr);
        return i;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int locks[] = {5, 3, 2, 1, 6, 4};

        int keys[] = {1, 4, 5, 6, 2, 3};

        matchPairs(locks, keys, 0, 5);

        utils.Utility.printArray(locks);
        System.out.println("");
        utils.Utility.printArray(keys);
    }
}
