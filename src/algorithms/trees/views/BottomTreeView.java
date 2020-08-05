/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees.views;

import java.util.HashMap;
import java.util.Map;
import utils.binarytree.Pair;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class BottomTreeView {
    
     public void bottomView(TreeNode root) {
        
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        view(root, map, 0, 0); 
        
        map.values().forEach((p) -> {
            System.out.print(p.first + " ");
        });
        
    }
    
   private void view (TreeNode node, Map<Integer, Pair<Integer, Integer>> map, int horDist, int level) {
        
        if (node == null) return;
        
        if (!map.containsKey(horDist) || level >= map.get(horDist).second) {
            map.put(horDist, Pair.of(node.val, level));
        }
        
        view(node.left, map, horDist - 1, level + 1);
        view(node.right, map, horDist + 1, level + 1);
    }
    
     public static void main(String[] args) {
        
        TreeNode root = new TreeNode(20);
        root.setLeft(new TreeNode(8));
        root.setRight(new TreeNode(22));
        
        root.getLeft().setLeft(new TreeNode(5));
        root.getLeft().setRight(new TreeNode(3));
        
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().setRight(new TreeNode(25));
        
        root.getLeft().getRight().setLeft(new TreeNode(10));
        root.getLeft().getRight().setRight(new TreeNode(14));
        
        BottomTreeView bv = new BottomTreeView();
        System.out.println("-- Bottom View  --");
        bv.bottomView(root);
        
    }
}
