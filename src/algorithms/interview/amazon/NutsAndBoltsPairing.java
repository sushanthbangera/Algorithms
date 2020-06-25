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
public class NutsAndBoltsPairing {

    public static void matchPairs(char[] nuts, char[] bolts, int low, int high) {

        if (low < high) {
            int pivot = partition(nuts, low, high, bolts[high]);
           
            partition(bolts, low, high, nuts[pivot]);
            
            matchPairs(nuts, bolts, low, pivot - 1);

            matchPairs(nuts, bolts, pivot + 1, high);
        }
    }

    private static int partition(char[] arr, int low, int high, char pivot) {

        int i = low;

        for (int j = i; j < high; j++) {

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

    private static void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};

        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        matchPairs(nuts, bolts, 0, 5);

        utils.Utility.printArray(nuts);
        System.out.println("");
        utils.Utility.printArray(bolts);
    }
}
