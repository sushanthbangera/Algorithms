/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.Objects;
import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class MirrorTreeCheck {
    
    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    public boolean isMirror(TreeNode treeNode1, TreeNode treeNode2) {
        
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        
        return Objects.equals(treeNode1.getVal(), treeNode2.getVal()) &&
               isMirror(treeNode1.getLeft(), treeNode2.getRight()) &&
                isMirror(treeNode1.getRight(), treeNode2.getLeft());
    }
}
