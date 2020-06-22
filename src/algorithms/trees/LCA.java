/*
 * https://www.youtube.com/watch?v=13m9ZCB8gjw&t=599s
 * Least Common Ancestor of 2 nodes
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class LCA {
    
    public static TreeNode LCA (TreeNode root, TreeNode n1, TreeNode n2) {
        
        if (root == null) {
            return null;
        }
        
        if (root == n1 || root == n2) {
            return root;
        }
       
        TreeNode left = LCA (root.getLeft(), n1, n2);
        
        TreeNode right = LCA (root.getRight(), n1, n2);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public static void main(String[] args) {

         /* Construct below tree
	          1
	        /   \
	       /     \
	      2       3
	       \     / \
	        4   5   6
	           / \
	          7   8
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println("LCA = " + LCA(root, root.right.left.left, root.right.left.right).val);
        
    }
}
