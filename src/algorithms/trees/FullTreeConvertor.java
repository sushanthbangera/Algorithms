/*
 * Convert the given Binary tree to complete tree by removing half nodes
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class FullTreeConvertor {

    /*
    The idea is to traverse the tree in bottom-up fashion and convert left and right 
    subtree first before processing a node. Then for each node,
    
    - if it has two children or it is a leaf node, nothing needs to be done.
    - if it has exactly one child, we delete it and replace the node by the child node.
     */
    public static TreeNode truncate(TreeNode root) {

        if (root == null) {
            return null;
        }

        root.left = truncate(root.left);
        root.right = truncate(root.right);

        if ((root.left != null && root.right != null) || isLeafNode(root)) {
            return root;
        }

        TreeNode child = root.left != null ? root.left : root.right;
        return child;
    }

    private static boolean isLeafNode(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    public static void main(String[] args) {
        /* Construct below tree
	                 0
	               /   \
	              /     \
	             1       2
	            /        /
	           /        /
	          3        4
	         /        / \
	        /        /   \
	       5        6     7
         */

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        truncate(root);

        InorderTraversal inOrder = new InorderTraversal();
        inOrder.inorder(root);

    }
}
