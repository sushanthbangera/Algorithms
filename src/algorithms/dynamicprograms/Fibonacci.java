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
        
        Utility.printArray(cache); // top down approach doesnt fill all the values
        
        System.out.println();
        
        cache = fib(n);
        Utility.printArray(cache);
    }
    
    // Top down uproach - Memoization
    private static int fibonacci(int n) {
        
        if (n < 2) {
            return n;
        }
        
        if (cache[n] > 0) {
            return cache[n];
        }
        
        return cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
  
    // Bottom up approach fills all the values
    private static int[] fib(int n) {
        
        int cache[] = new int[n + 1];
        
        cache[0] = 0;
        cache[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        
        return cache;
    }
    
    private static int simpleFib(int n) {
        
        int a = 0, b = 1, c = 0;
        
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
     }
}
