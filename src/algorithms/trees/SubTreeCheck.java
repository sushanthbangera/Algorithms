/*
 * Check if a tree is a sub tree of the other
 *
 */
package algorithms.trees;

import utils.binarytree.Node;

/**
 *
 * @author Sushanth Bangera
 */
public class SubTreeCheck {
    
    public boolean isSubTree(Node mainTree, Node subTree) {
        
        if (subTree == null) {
            return true; // null tree is always a sub tree
        }
        
        if(mainTree == null) {
            return false; // if main tree is null, then there cant be sub tree
        }
        
        // check from the root
        if(isIdentical(mainTree, subTree)) {
            return true;
        }
        
        // if its not identical from root, check its left and right sub tree
        return isIdentical(mainTree.getLeft(), subTree.getLeft()) ||
                isIdentical(mainTree.getRight(), subTree.getRight());
    }
    
   public static boolean isIdentical(Node node1, Node node2) {
        
        if (node1 == null && node2 == null) {
            return true;
        }
        
        if (node1 != null && node2 != null) {
            return (node1.getData() == node2.getData()) && 
                    isIdentical(node1.getLeft(), node2.getLeft()) &&
                    isIdentical(node1.getRight(), node2.getRight());
        }
        
        return false;
    }
}
