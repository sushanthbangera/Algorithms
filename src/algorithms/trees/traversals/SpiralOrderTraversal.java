/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees.traversals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class SpiralOrderTraversal {

    /*
    Time: O(n)
    Space: O(2n)
     */
    public static void spiralOrderTraversal(TreeNode node) {

        boolean isLeftToRight = false;

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currentLevel.push(node);

        TreeNode currentNode = null;

        while (!currentLevel.isEmpty()) {

            int size = currentLevel.size();

            while (size-- > 0) {

                currentNode = currentLevel.pop();
                System.out.print(currentNode.val + " ");

                if (isLeftToRight) {
                    if (currentNode.left != null) {
                        nextLevel.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        nextLevel.push(currentNode.right);
                    }
                } else {
                    if (currentNode.right != null) {
                        nextLevel.push(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        nextLevel.push(currentNode.left);
                    }
                }
            }

            if (currentLevel.empty()) {
                isLeftToRight = !isLeftToRight;
                Stack<TreeNode> temp = nextLevel;
                nextLevel = currentLevel;
                currentLevel = temp;
            }
        }

    }

    /*
    Time: O(n)
    Space: O(n)
     */
    public static void spiralOrderTraversal2(TreeNode node) {

        if (node == null) {
            return;
        }

        boolean isLeftToRight = false;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(node);
        TreeNode currentNode = null;

        while (!deque.isEmpty()) {

            int size = deque.size();

            while (size-- > 0) {

                if (isLeftToRight) {
                    currentNode = deque.pollFirst();
                    System.out.print(currentNode.val + " ");

                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }
                } else {
                    currentNode = deque.pollLast();
                    System.out.print(currentNode.val + " ");

                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }
                }
            }
            isLeftToRight = !isLeftToRight;
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

        spiralOrderTraversal(root);

        System.out.println();
        spiralOrderTraversal2(root);
    }
}
