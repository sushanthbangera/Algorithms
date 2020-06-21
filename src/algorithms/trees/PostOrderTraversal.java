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
public class PostOrderTraversal {

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    
    public void postOrderIterative(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode cur = null;
        
        Stack<Integer> outStack = new Stack<>();
        
        while (!stack.isEmpty()) {
            
            cur = stack.pop();
            outStack.push(cur.val);
            
            if (cur.left != null) {
                stack.push(cur.left);
            }
            
            if (cur.right != null) {
                stack.push(cur.right);
            }
         }
        
        while (!outStack.isEmpty()) {
            System.out.print(outStack.pop() + " ");
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

        PostOrderTraversal po = new PostOrderTraversal();
        
        po.postOrder(root);
        System.out.println();
        po.postOrderIterative(root);
    }
}
