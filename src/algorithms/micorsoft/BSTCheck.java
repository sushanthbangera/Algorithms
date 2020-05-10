/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.micorsoft;

/**
 * To find the given tree is BST or not
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 * 
 * @author Sushanth Bangera
 */

public class BSTCheck {
    
    public static void main(String[] args) {
        
    }
    
    public boolean isValid(int min, int max, int currentVal) {
        return currentVal >= min && currentVal <= max;
    }
    
}
