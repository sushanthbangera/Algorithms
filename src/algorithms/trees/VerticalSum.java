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
        
        if (root == null) return;
        
        map.put(dist, map.getOrDefault(dist, 0) + root.val);
        
        verticalSum(root.left, dist - 1, map);
        verticalSum(root.right, dist + 1, map);
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
    }
}
