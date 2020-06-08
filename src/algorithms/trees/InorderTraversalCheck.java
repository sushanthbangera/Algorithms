/*
 * https://www.youtube.com/watch?v=7lbwfkCfNQ4&t=473s
 * 
 */
package algorithms.trees;

import java.util.ArrayList;
import java.util.List;
import utils.binarytree.Node;

/**
 *
 * @author Sushanth Bangera
 */
public class InorderTraversalCheck {

    /*
     2 list are used which can be optimized
     */
    public static boolean checkInoderTraversal(Node n1, Node n2) {

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
    public static boolean checkInoderTraversal2(Node n1, Node n2) {

        List<Integer> node1List = new ArrayList<>();
        inorderTraversal(n1, node1List);

        // all nodes should be deleted
        return (checkInorderTraversal(n2, node1List) && node1List.isEmpty());
    }

    private static void inorderTraversal(Node node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.getLeft(), nodeList);
        nodeList.add(node.getData());
        inorderTraversal(node.getRight(), nodeList);
    }

    private static boolean checkInorderTraversal(Node node, List<Integer> nodeList1) {
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

        Node root = new Node(5);
        root.setLeft(new Node(3));
        root.getLeft().setLeft(new Node(1));

        root.setRight(new Node(7));
        root.getRight().setLeft(new Node(6));

        Node root2 = new Node(3);
        root2.setLeft(new Node(1));

        root2.setRight(new Node(6));
        root2.getRight().setLeft(new Node(5));
        root2.getRight().setRight(new Node(7));

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
