/*
 Given a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on. 
 You are given a number N, you have to print the number of integers less than N in the sample space S.
 */
package algorithms;

import java.util.Scanner;

/**
 *
 * @author Sushanth Bangera
 */
public class SquaresCounter {

    public static void main(String[] args) {
        int N;
        try (Scanner in = new Scanner(System.in)) {
            N = in.nextInt();
        }
        
        int squareCount = 0;
        for (int i = 1; i < N;) {
            if (isPerfectSquare(i)) {
                squareCount++;
                double next = Math.sqrt(i);
                i = (int) ((next + 1) * (next + 1));
            } else {
                i++;
            }
        }
        System.out.println(squareCount);
    }

    // Method to check if given number is square or not
    private static boolean isPerfectSquare(int n) {
        if (n == 1) {
            return true;
        }
        double root = Math.sqrt(n);
        return n == (root * root);
    }
}
