//
//Context 
//Given 6 X 6  2D Array, A:
//
//1 1 1 0 0 0
//0 1 0 0 0 0
//1 1 1 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:
//
//a b c
//  d
//e f g
//There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.
//
//Task : Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.
//
//Input Format
//
//There are 6 lines of input, where each line contains 6 space-separated integers describing 2D Array A; every value in A  will be in the
//inclusive range of -9 to 9.
//
//Constraints -9 <= A[i][j] <= 9
//  0 <= i,j <= 5
//
//Output Format : Print the largest (maximum) hourglass sum found in A.
package algorithms.matrices;

/**
 *
 * @author Sushanth Bangera
 */
public class HourGlassMaxSumFinder {

    public static int getHourGlassMaxSum(int arr[][]) {
        int len = arr.length, hourGlassSum = 0, maxHourGlassSum = Integer.MIN_VALUE;
        for (int i = 0; i < len - 2; i++) {
            for (int j = 0; j < len - 2; j++) {
                hourGlassSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                maxHourGlassSum = (hourGlassSum > maxHourGlassSum) ? hourGlassSum : maxHourGlassSum;
            }
        }
        return maxHourGlassSum;
    }
}
