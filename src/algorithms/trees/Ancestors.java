/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class Ancestors {
    
    /*
    Time: O(n)
    Space: O(h) - for call stack
    */
    public boolean getAncestors(TreeNode root, int node) {
        
        if (root == null) return false; 
        
        // if the given node is found return true
        if (root.val == node) return true;
        
        // search the node in the left sub tree
        boolean left = getAncestors(root.left, node);
        
        // if its not found in left sub tree, search the right sub tree
        boolean right = false;
        
        if (!left) {
            right = getAncestors(root.right, node);
        }
        
        // if the node is found in either left or right sub tree, then 
        // root is the ancestor
        if (left || right) {
            System.out.print(root.val + " ");
        }
        
        return left || right;
    }
    
}
