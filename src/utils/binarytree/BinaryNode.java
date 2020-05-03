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
public class BinaryNode {
    
    private Integer data;
    
    private BinaryNode left;
    
    private BinaryNode right;

    public BinaryNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
   
}
