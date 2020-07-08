/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.HashMap;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class VerticalSum {

    public void verticalSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        verticalSum(root, 0, map);

        map.entrySet().forEach(item -> {
            System.out.println("Depth :" + item.getKey() + "->" + item.getValue());
        });
    }

    public void verticalSum(TreeNode root, int dist, HashMap<Integer, Integer> map) {

        if (root == null) {
            return;
        }

        map.put(dist, map.getOrDefault(dist, 0) + root.val);

        verticalSum(root.left, dist - 1, map);
        verticalSum(root.right, dist + 1, map);
    }

    static void verticalSumDLL(TreeNode root) {
        // Create a doubly linked list node to 
        // store sum of lines going through root. 
        // Vertical sum is initialized as 0. 
        LLNode llnode = new LLNode(0);

        // Compute vertical sum of different lines 
        verticalSumDLLUtil(root, llnode);

        // llnode refers to sum of vertical line 
        // going through root. Move llnode to the 
        // leftmost line. 
        while (llnode.prev != null) {
            llnode = llnode.prev;
        }

        // Prints vertical sum of all lines starting 
        // from leftmost vertical line 
        while (llnode != null) {
            System.out.print(llnode.data + " ");
            llnode = llnode.next;
        }
    }

    // Constructs linked list 
    static void verticalSumDLLUtil(TreeNode tnode, LLNode llnode) {
        // Add current node's data to its vertical line 
        llnode.data = llnode.data + tnode.val;

        // Recursively process left subtree 
        if (tnode.left != null) {
            if (llnode.prev == null) {
                llnode.prev = new LLNode(0);
                llnode.prev.next = llnode;
            }
            verticalSumDLLUtil(tnode.left, llnode.prev);
        }

        // Process right subtree 
        if (tnode.right != null) {
            if (llnode.next == null) {
                llnode.next = new LLNode(0);
                llnode.next.prev = llnode;
            }
            verticalSumDLLUtil(tnode.right, llnode.next);
        }
    }

    static class LLNode {

        int data;
        LLNode prev, next;

        public LLNode(int d) {
            data = d;
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

        VerticalSum v = new VerticalSum();
        v.verticalSum(root);

        verticalSumDLL(root);
    }
}
