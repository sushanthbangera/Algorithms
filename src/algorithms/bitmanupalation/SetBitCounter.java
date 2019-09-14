/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.bitmanupalation;

/**
 *
 * @author Sushanth Bangera
 */
public class SetBitCounter {
    
    public static void main(String[] args) {
        int n = 6;
        System.out.println("The count of set bits = " + getSetBitCount(n));
    }
    
    private static int getSetBitCount(int n) {
        int count = 0;
        
        while(n > 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}
