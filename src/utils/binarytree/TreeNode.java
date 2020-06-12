/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.binarytree;

/**
 *
 * @author Sushanth Bangera
 */
public class TreeNode {
    
    private Integer val;
    
    private TreeNode left;
    
    private TreeNode right;

    public TreeNode(Integer data) {
        this.val = data;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer data) {
        this.val = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
   
}
