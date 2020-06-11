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
        return validateBST(tree, null, null);
    }

    private boolean validateBST(TreeNode root, Integer max, Integer min) {

        if (root == null) {
            return true;
        }
        // Value of root shouln't be grater than max value or less than min Value
        if (max != null && root.getData() >= max || min != null && root.getData() <= min) {
            return false;
        }
        // For left node max Value would be root value and min is the current minimum
        // For right node, max value is the current max value and min is the root value
        return validateBST(root.getLeft(), root.getData(), min)
                && validateBST(root.getRight(), max, root.getData());
    }
}
