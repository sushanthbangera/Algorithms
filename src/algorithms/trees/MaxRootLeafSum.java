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
public class MaxRootLeafSum {

    public int maxLeafPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxLeafPathSum(root.left);
        int right = maxLeafPathSum(root.right);

        return Math.max(left, right) + root.val;
    }
    
    public boolean leafRootSumExists(TreeNode root, int sum) {
        
        if (root == null) return (sum == 0);

        boolean left = leafRootSumExists(root.left, sum - root.val);
        boolean right = leafRootSumExists(root.right, sum - root.val);
        
        return left || right;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        TreeNode tree = new TreeNode(10);

        tree.setLeft(new TreeNode(2));
        tree.setRight(new TreeNode(10));

        tree.getLeft().setLeft(new TreeNode(20));
        tree.getLeft().setRight(new TreeNode(1));

        tree.getRight().setRight(new TreeNode(-25));
        tree.getRight().setLeft(new TreeNode(15));
        tree.getRight().getRight().setLeft(new TreeNode(3));
        tree.getRight().getRight().setRight(new TreeNode(4));

        System.out.println("maximum path sum is : "
                + new MaxRootLeafSum().maxLeafPathSum(tree));
        
        System.out.println("Sum path sum is : "
                + (new MaxRootLeafSum().leafRootSumExists(tree, 32) ? "presemt" : "Not present"));
    }

}
