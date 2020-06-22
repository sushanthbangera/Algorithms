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
public class NodesDistance {

    public int getDistance(TreeNode root, TreeNode a, TreeNode b) {

        TreeNode LCA = LCA(root, a, b);

        System.out.println("LCA is: " + LCA.val);

        // return level (root, a, 0) + level (root, b, 0) - 2*level(root, LCA, 0);
        return findLevel(LCA, a, 0) + findLevel(LCA, b, 0);
    }

    private TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {

        if (root == null) {
            return null;
        }

        if (root == a || root == b) {
            return root;
        }

        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private int level(TreeNode root, TreeNode node, int level) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root == node) {
            return level;
        }
        // search node in left subtree
        int left = level(root.left, node, level + 1);

        if (left != Integer.MIN_VALUE) {
            return left;
        }

        return level(root.right, node, level + 1);
    }

    public int findLevel(TreeNode root, TreeNode node, int level) {
        // base case
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // return level if node is found
        if (root == node) {
            return level;
        }

        // search node in left subtree
        int left = findLevel(root.left, node, level + 1);

        // if node is found in left subtree, return
        if (left != Integer.MIN_VALUE) {
            return left;
        }

        // else continue the search in right subtree
        return findLevel(root.right, node, level + 1);
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

        NodesDistance nd = new NodesDistance();
        // find distance between node 7 and node 6
        //System.out.print(nd.getDistance(root, root.right.left.left, root.right.right));

        // find distance between node 7 and node 8
        System.out.print(nd.getDistance(root, root.right.left.left, root.right.left.right));
    }
}
