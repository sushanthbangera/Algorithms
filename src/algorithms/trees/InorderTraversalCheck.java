/*
 * https://www.youtube.com/watch?v=7lbwfkCfNQ4&t=473s
 * 
 */
package algorithms.trees;

import java.util.ArrayList;
import java.util.List;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class InorderTraversalCheck {

    /*
     2 list are used which can be optimized
     */
    public static boolean checkInoderTraversal(TreeNode n1, TreeNode n2) {

        List<Integer> node1List = new ArrayList<>();
        inorderTraversal(n1, node1List);

        List<Integer> node2List = new ArrayList<>();
        inorderTraversal(n2, node2List);

        return node1List.equals(node2List);
    }

    /*
     Using only 1 list
     Time Complexity: O(m + n)
     Space Complexity: O(m + n) //  list and inorder traversal
     */
    public static boolean checkInoderTraversal2(TreeNode n1, TreeNode n2) {

        List<Integer> node1List = new ArrayList<>();
        inorderTraversal(n1, node1List);

        // all nodes should be deleted
        return (checkInorderTraversal(n2, node1List) && node1List.isEmpty());
    }

    private static void inorderTraversal(TreeNode node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.getLeft(), nodeList);
        nodeList.add(node.getData());
        inorderTraversal(node.getRight(), nodeList);
    }

    private static boolean checkInorderTraversal(TreeNode node, List<Integer> nodeList1) {
        if (node == null) {
            return true;
        }
        if (!checkInorderTraversal(node.getLeft(), nodeList1)) {
            return false;
        }

        if (nodeList1.isEmpty() || nodeList1.get(0) != node.getData()) {
            return false;
        }
        nodeList1.remove(0);

        return checkInorderTraversal(node.getRight(), nodeList1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(1));

        root.setRight(new TreeNode(7));
        root.getRight().setLeft(new TreeNode(6));

        TreeNode root2 = new TreeNode(3);
        root2.setLeft(new TreeNode(1));

        root2.setRight(new TreeNode(6));
        root2.getRight().setLeft(new TreeNode(5));
        root2.getRight().setRight(new TreeNode(7));

        if (checkInoderTraversal(root, root2)) {
            System.out.println("Trees have same inorder traversal");
        } else {
            System.out.println("Trees do not have same inorder traversal");
        }

        if (checkInoderTraversal2(root, root2)) {
            System.out.println("Trees have same inorder traversal");
        } else {
            System.out.println("Trees do not have same inorder traversal");
        }
    }
}
