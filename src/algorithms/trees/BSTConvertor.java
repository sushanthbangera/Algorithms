/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class BSTConvertor {

    public void convertTreeToBST(TreeNode root) {
        // traverse the binary tree and store its keys in a set
        Set<Integer> keys = new TreeSet<>();
        extractKeys(root, keys);
        
        // put back keys present in set in their correct order in BST
        Iterator<Integer> it = keys.iterator();
        convertToBST(root, it); 
        
        inorderTraversal(root);
    }
    
    private void extractKeys(TreeNode root, Set<Integer> keys) {
        if (root == null) return;
        
        extractKeys(root.left, keys);
        keys.add(root.val);
        extractKeys(root.right, keys);
    }
    
    private void convertToBST(TreeNode root, Iterator<Integer> it) {
        if (root == null) return;
        
        convertToBST(root.left, it);
        root.val = it.next();
        convertToBST(root.right, it);
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    
    public static void main(String[] args) {
        /* Construct below tree
			  8
			/   \
		       /     \
		      3       5
		     / \     / \
		    /   \   /   \
		   10    2 4     6
         */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        
        BSTConvertor bst = new BSTConvertor();
        
        bst.inorderTraversal(root);
        System.out.println();
        bst.convertTreeToBST(root);
    }
}
