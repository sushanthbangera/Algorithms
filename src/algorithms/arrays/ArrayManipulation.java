/*
 You are given a list(1-indexed) of size n, initialized with zeroes. You have to perform  
 m operations on the list and output the maximum of final values of all the n elements in the list. 
 For every operation, you are given three integers a, b and k and you have to add value 
 k to all the elements ranging from index a to b (both inclusive).

 For example, consider a list a of size 3. The initial list would be  = [0, 0, 0] and after performing the 
 update  o(a,b,1k)= [2, 3, 30], the new list would be  = [0, 30, 30]. Here, we've added value 30 to elements 
 between indices 2 and 3. Note the index of the list starts from 1.
 */
package algorithms.arrays;

import java.util.Scanner;

/**
 *
 * @author Sushanth Bangera
 */
public class ArrayManipulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long arr[] = new long[n];
        for (int j = 0; j < n; j++) {
            arr[j] = 0;
        }
        /*
        Instead of storing the actual values in the array, you store the difference
        between the current element and the previous element. So you add sum to a[p] 
        showing that a[p] is greater than its previous element by sum. You subtract sum
        from a[q+1] to show that a[q+1] is less than a[q] by sum (since a[q] was the last element 
        that was added to sum). By the end of all this, you have an array that shows the 
        difference between every successive element. By adding all the positive differences,
        you get the value of the maximum element
        */
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            
            int k = in.nextInt();
            arr[a - 1] += k;
            if (b < n) {
                arr[b] -= k;
            }
        }

        long max = 0;
        long temp = 0;

        for (int i = 0; i < n; i++) {
            temp += arr[i];
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
        in.close();
    }
}
