/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class ReverseLevelOrder {

    /*
    Time: O(n) Space: O(2n)
    */
    public void reverseLevelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {

            TreeNode curNode = queue.poll();
            stack.push(curNode.val);

            if (curNode.right != null) {
                queue.add(curNode.right);
            }

            if (curNode.left != null) {
                queue.add(curNode.left);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));

        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));

        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        
       
        ReverseLevelOrder reverseLevelOrder = new ReverseLevelOrder();
        reverseLevelOrder.reverseLevelOrder(root);
    }
}
