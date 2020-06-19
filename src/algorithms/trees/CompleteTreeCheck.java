/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class CompleteTreeCheck {

    public static boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode currentNode;
        boolean nonFullNode = false;

        while (!queue.isEmpty()) {

            currentNode = queue.poll();

            // if we have encountered a non-full node already and current node
            // is not a leaf then tree is not a complete tree
            if (nonFullNode && (currentNode.left != null || currentNode.right != null)) {
                return false;
            }

            // Tree is not complete if left node is null and right node exists
            if (currentNode.left == null && currentNode.right != null) {
                return false;
            }

            // If left node exists enqueue it
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            } else {
                nonFullNode = true; // currentNode is a non full Node
            }

            // If right node exists enqueue it
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            } else {
                nonFullNode = true; // currentNode is a non full Node
            }
        }
        return true;
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        if (isCompleteTree(root)) {
            System.out.print("Given Binary Tree is a Complete Binary Tree");
        } else {
            System.out.print("Given Binary Tree is not a Complete Binary Tree");
        }
    }

}
