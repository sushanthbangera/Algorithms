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
public class InorderTraversal {

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void inorderInterative(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (!stack.empty() || curr != null) {

            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
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
        
        InorderTraversal inOrder = new InorderTraversal();
        inOrder.inorder(root);
        
        System.out.println();
        
        inOrder.inorderInterative(root);
    }
    
}
