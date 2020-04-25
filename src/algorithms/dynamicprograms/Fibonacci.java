/*
 *  Fibonacci using Dynamic programming
 */
package algorithms.dynamicprograms;

import utils.Utility;

/**
 *
 * @author Sushanth Bangera
 */
public class Fibonacci {
    
    private static int cache[];
    
    public static void main(String[] args) {
        int n = 5;
        cache = new int[n + 1];
        fibonacci(n);
        Utility.printArray(cache);
    }
    
    private static int fibonacci(int n) {
        
        if (n < 2) {
            return n;
        }
        
        if (cache[n] > 0) {
            return cache[n];
        }
        
        return cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
  
}
