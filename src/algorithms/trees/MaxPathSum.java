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
public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        Result res = new Result();
        res.val = Integer.MIN_VALUE;

        maxPathSum(root, res);

        return res.val;
    }
    
    private int maxPathSum(TreeNode root, Result result) {

        if (root == null) {
            return 0;
        }

        // To store max sum obtained from left path
        int leftSum = maxPathSum(root.getLeft(), result);

        // To store max sum obtained from right path
        int rightSum = maxPathSum(root.getRight(), result);

        // To store straight sum path where root is the part of max sum path
        int maxStraightPathSum = Math.max((Math.max(leftSum, rightSum) + root.getVal()), root.getVal());
        
        // if the current root itself has the maxSum
        int m21 = Math.max(maxStraightPathSum, leftSum + rightSum + root.getVal());

        result.val = Math.max(result.val, m21);

        // when propagating only left path or right path has to propagate up
        return maxStraightPathSum;
    }

    class Result {

        public int val;

    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        TreeNode tree = new TreeNode(10);

        tree.setLeft(new TreeNode(2));
        tree.setRight(new TreeNode(10));

        tree.getLeft().setLeft(new TreeNode(20));
        tree.getLeft().setRight(new TreeNode(1));

        tree.getRight().setRight(new TreeNode(-25));
        tree.getRight().getRight().setLeft(new TreeNode(3));
        tree.getRight().getRight().setRight(new TreeNode(4));

        System.out.println("maximum path sum is : "
                + new MaxPathSum().maxPathSum(tree));   
    }
}
