/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.Stack;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class PreOrderTraversal {
    
    public void preOrder(TreeNode root) {
        
        if (root == null) return;
        
        System.out.print(root.val + " ");
        
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void preOrderIterative (TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode cur = null;
        
        while (!stack.isEmpty()) {
            
            cur = stack.pop();
            System.out.print(cur.val + " ");
            
            if (cur.right != null) {
                stack.push(cur.right);
            }
            
            if (cur.left != null) {
                stack.push(cur.left);
            }
            
        }
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
        
        PreOrderTraversal preOder = new PreOrderTraversal();
        preOder.preOrder(root);
        
        System.out.println();
        
        preOder.preOrderIterative(root);
        
    }
}
