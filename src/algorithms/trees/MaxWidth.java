/*
 * To find the max Width of the given Binary Tree
 */
package algorithms.trees;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class MaxWidth {

    /*
    Time O(n) ; Space O(n) for queue
    */
    public int maxWidth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int size = 0, maxSize = Integer.MIN_VALUE;
        TreeNode curNode;

        while (!queue.isEmpty()) {

            size = queue.size();
            maxSize = Math.max(size, maxSize);

            while (size-- > 0) {

                curNode = queue.remove();

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return maxSize;
    }

    /*
    Time O(n) ; Space O(n) for stack
    */
    public int maxWidth2(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        preOrder(root, map, 0);
        int maxWidth = map.values().stream().max(Comparator.naturalOrder()).get();
        return maxWidth;
    }

    public void preOrder(TreeNode root, HashMap<Integer, Integer> map, int level) {

        if (root == null) {
            return;
        }

        map.put(level, map.getOrDefault(level, 0) + 1);

        preOrder(root.left, map, level + 1);
        preOrder(root.right, map, level + 1);
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

        MaxWidth m = new MaxWidth();
        System.out.println("Max Width (Iterative):" + m.maxWidth(root));
        System.out.println("Max Width (Recursive):" + m.maxWidth2(root));

    }
}
