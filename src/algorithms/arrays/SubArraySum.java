/*
 Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

 Input: The first line of each test case is N and S, where N is the size of array and S is the sum. 
 The second line of each test case contains N space separated integers denoting the array elements.

 Output: Corresponding to each test case, in a new line, print the starting and ending positions of 
 first such occuring subarray if sum equals to subarray, else print -1.

 */
package algorithms.arrays;

import algorithms.*;
import java.util.Scanner;

class SubArraySum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, S;
        N = in.nextInt();
        S = in.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        printSubArraySumIndexes(arr, N, S);
    }

    public static void printSubArraySumIndexes(int arr[], int N, int targetSum) {
        int startIndex = 0, stopIndex = 0;
        int currentSum = arr[0];

        for (int i = 1; i < N; i++) {
            // If Sum is greater than target sum remove the starting elements
            while (currentSum > targetSum && startIndex < i - 1) {
                currentSum = currentSum - arr[startIndex];
                startIndex++;
            }
            // Print the start index and last index of sub array
            if (currentSum == targetSum) {
                System.out.println(startIndex + " " + stopIndex);
                return;
            }
            currentSum += arr[i];
            stopIndex++;
        }
        System.out.println(-1);
    }
}
