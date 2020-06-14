/*
 * Convert a given tree to its mirror version
 * 
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class MirrorTree {
    
    public TreeNode mirror(TreeNode node) {
        
        if (node == null) return node;
        
        TreeNode left = mirror(node.getLeft());
        
        TreeNode right = mirror(node.getRight());
        
        node.setLeft(right);
        
        node.setRight(left);
        
        return node;
    }
}
