/*
 * Program to check if the given 2 nodes are cousins
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class CousinsCheck {

    public boolean isCousins(TreeNode root, TreeNode a, TreeNode b) {

        return (level(root, a, 1) == level(root, b, 1)) && !isSiblings(root, a, b);
    }

    private int level(TreeNode root, TreeNode n, int level) {

        if (root == null) {
            return 0;
        }

        if (root == n) {
            return level;
        }

        int lev = level(root.left, n, level + 1);

        if (lev != 0) {
            return lev;
        }

        return level(root.right, n, level + 1);
    }

    private boolean isSiblings(TreeNode root, TreeNode a, TreeNode b) {

        if (root == null) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        return ((left == a && right == b) || (right == a || left == b) || isSiblings(root.left, a, b) || isSiblings(root.right, a, b));
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        TreeNode Node1, Node2;
        Node1 = root.left.left;
        Node2 = root.right.right;

        CousinsCheck cousinsCheck = new CousinsCheck();
        if (cousinsCheck.isCousins(root, Node1, Node2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
