/*
 * To find the missing number/s in an given array
 */
package algorithms.arrays;

import algorithms.*;
import java.util.Arrays;
import java.util.BitSet;

/**
 *
 * @author Sushanth Bangera
 */
public class MissingNumberInArray {

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("The missing number is " + getMissingNumber(arr, 10));
        int new_arr[] = {1, 3, 7, 5, 6, 8, 9, 10};
        getMissingNumbers(new_arr, 10);
    }

    /*
     when there is one missing number in an array
     */
    public static int getMissingNumber(int arr[], int count) {
        int totalSumOfDigits = count * (count + 1) / 2; // Sum of N consecutive numbers
        int sumOfDigits = 0;
        for (int a : arr) {
            sumOfDigits += a;
        }
        return totalSumOfDigits - sumOfDigits;
    }

    /*
     1. when there are more than one missing number in an array
     2. when missing numbers are not sorted
     
     */
    public static void getMissingNumbers(int arr[], int count) {
        int missingCount = count - arr.length;
        BitSet bitSet = new BitSet(count);

        for (int number : arr) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(arr), count);

        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }
}
