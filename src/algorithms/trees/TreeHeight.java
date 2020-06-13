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
public class TreeHeight {
    
    public int maxDepth(TreeNode node) {
        
        if (node == null) return 0;
        
        int leftDepth = maxDepth(node.getLeft());
        int rightDepth = maxDepth(node.getRight());
        
        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }
}
