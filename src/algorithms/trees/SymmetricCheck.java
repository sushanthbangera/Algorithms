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
public class SymmetricCheck {
    
    public boolean isSymmetric(TreeNode root) {
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        
        if (leftNode == null && rightNode == null) return true;
        
        return (leftNode != null && rightNode != null) &&
                isSymmetric(leftNode.left, rightNode.right) && 
                isSymmetric(leftNode.right, rightNode.left);
    }
}
