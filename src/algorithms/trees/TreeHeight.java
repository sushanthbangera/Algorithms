/*
 * Find the max depth of the root or height of the tree
 * 
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class TreeHeight {

    public int maxDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.getLeft());
        int rightDepth = maxDepth(node.getRight());

        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }
}
