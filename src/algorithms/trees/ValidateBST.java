/*
 *  Validating if the given tree is Binary Search tree or not
 *  i.e. Left node is less than root node and right node is greater than root
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode tree) {
        return validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBST(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }
        // Value of root shouldn't be grater than max value or less than min Value
        if (root.getVal() >= max || root.getVal() <= min) {
            return false;
        }
        // For left node max Value would be root value and min is the current minimum
        // For right node, max value is the current max value and min is the root value
        return validateBST(root.getLeft(), min, root.getVal())
                && validateBST(root.getRight(), root.getVal(), max);
    }
}
