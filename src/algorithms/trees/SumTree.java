/*
 * Given a binary tree, check if it is a sum tree or not. 
 * In a sum tree, value at each non-leaf node is equal to the sum of all elements
 * present in its left and right subtree. The value of a leaf node can be anything.
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class SumTree {

    /*
        Time: O(n)
        Space: O(h)
    */
    public static int isSumTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = isSumTree(root.left);
        int right = isSumTree(root.right);

        if (root.val == (left + right)) {
            return 2 * root.val;
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        /* Construct below tree
		         44
		        /  \
		       /    \
		      9     13
		     / \    / \
		    4   5  6   7
         */

        TreeNode root = new TreeNode(44);
        root.left = new TreeNode(9);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print(isSumTree(root) != Integer.MIN_VALUE ? "Yes" : "No");
    }
}
