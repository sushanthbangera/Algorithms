/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees.views;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class LeftTreeView {
    
    public static void leftView(TreeNode tree) {
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        
        TreeNode currentNode = null;
        
         while (!queue.isEmpty()) {
             
             int size = queue.size();
             int i = 0;
             
             while (i++ < size) {
                 
                 currentNode = queue.poll();
                 
                 if (i == 1) {
                     System.out.print(currentNode.val + " ");
                 }
                 
                 if (currentNode.left != null) {
                     queue.add(currentNode.left);
                 }
                 
                 if (currentNode.right != null) {
                     queue.add(currentNode.right);
                 }
             }
         }
         System.out.println();
    }
    
    public static void leftViewRecursion(TreeNode node) {
        
        if (node == null) {return;}
        
        HashMap<Integer, TreeNode> map = new HashMap<>();
        
        leftViewRecursion(node, 1, map);
        
        map.entrySet().forEach(n -> {
            System.out.print(n.getValue().val + " ");
        });
        
        System.out.println();
    }
    
     public static void leftViewRecursion(TreeNode node, int level, HashMap<Integer, TreeNode> map) {
        
        if (node == null) {return;}
        
        if (!map.containsKey(level)) {
            map.put(level, node);
        }
        
         leftViewRecursion(node.left, level + 1, map);
         leftViewRecursion(node.right, level + 1, map);
    }
    
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        
        root.setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(9));
        
        System.out.println("-- Left View Method 2 --");
        leftView(root);
        
        System.out.println("-- Left View Method Recursion --");
        leftViewRecursion(root);
    }
}
