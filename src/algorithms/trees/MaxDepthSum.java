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
public class MaxDepthSum {
    
    static int sum = 0, maxLevel = Integer.MIN_VALUE;
    
    public static void maxDepthSum(TreeNode root, int level) {
        
        if (root == null) return;
        
        if (level > maxLevel) {
            sum = root.val;
            maxLevel = level;
        } else if (level == maxLevel) {
            sum += root.val;
        }
        
        maxDepthSum(root.left, level + 1);
        maxDepthSum(root.right, level + 1);
    } 
    
    public static void main(String[] args) {
        
        /* Construct below tree
		          1
		       /     \
		      2       3
		     / \     / \
		    4   5   6   7
         */

        TreeNode root = new TreeNode(1);

        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));

        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));

        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        
        maxDepthSum(root, 0);
        System.out.println("Max depth sum: " + sum);
    }
}
