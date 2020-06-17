/*
 * Find the max depth of the root or height of the tree
 * 
 */
package algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;
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

    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int height = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                TreeNode node = queue.remove();

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            height++;
        }

        return height;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);

        TreeHeight treeHeight = new TreeHeight();
        
        System.out.println("The height of the binary tree is " + treeHeight.maxDepth(root));
                
        System.out.println("The height of the binary tree is " + treeHeight.height(root)); 
    }
}
