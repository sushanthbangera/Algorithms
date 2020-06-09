/*
 * To check if two trees are identical
 * 
 */
package algorithms.trees;

import utils.binarytree.BinaryNode;

/**
 *
 * @author Sushanth Bangera
 */
public class IdenticalTreeCheck {

    // Time complexity: O(m)
    // m and n are the lengths of the tree where m <= n
    public static boolean isIdentical(BinaryNode tree1, BinaryNode tree2) {

        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 != null && tree2 != null) {
            return (tree1.getData() == tree2.getData())
                    && isIdentical(tree1.getLeft(), tree2.getLeft())
                    && isIdentical(tree1.getRight(), tree2.getRight());
        }
        return false;
    }

    public static void main(String[] args) {

        BinaryNode tree1 = new BinaryNode(1);
        BinaryNode leftree1 = new BinaryNode(3);
        BinaryNode rightree1 = new BinaryNode(5);
        tree1.setLeft(leftree1);
        tree1.setRight(rightree1);
        leftree1.setLeft(new BinaryNode(7));

        BinaryNode tree2 = new BinaryNode(1);
        BinaryNode leftree2 = new BinaryNode(3);
        BinaryNode rightree2 = new BinaryNode(5);
        tree2.setLeft(leftree2);
        tree2.setRight(rightree2);
        leftree2.setLeft(new BinaryNode(8));

        if (isIdentical(tree1, tree2)) {
            System.out.println("Trees are identical");
        } else {
            System.out.println("Trees are not identical");
        }
    }
}
