/*
 * https://www.youtube.com/watch?v=13m9ZCB8gjw&t=599s
 * Least Common Ancestor of 2 nodes
 */
package algorithms.trees;

import utils.binarytree.TreeNode;

/**
 *
 * @author Sushanth Bangera
 */
public class LCA {
    
    public static TreeNode LCA (TreeNode root, TreeNode n1, TreeNode n2) {
        
        if (root == null) {
            return null;
        }
        
        if (root == n1 || root == n2) {
            return root;
        }
       
        TreeNode left = LCA (root.getLeft(), n1, n2);
        
        TreeNode right = LCA (root.getRight(), n1, n2);
        
        if (left == null && right == null) {
            return null;
        } 
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        
        TreeNode a = new TreeNode(6);
        root.setLeft(a);
        
        TreeNode b = new TreeNode(2);
        root.getLeft().setLeft(b);
        
        TreeNode c = new TreeNode(11);
        root.getLeft().setRight(c);
        
        TreeNode d = new TreeNode(9);
        root.getLeft().getRight().setLeft(d);
        
        TreeNode e = new TreeNode(5);
        root.getLeft().getRight().setRight(e);
        
        TreeNode f = new TreeNode(8);
        root.setRight(f);
        
        TreeNode g = new TreeNode(13);
        root.getRight().setRight(g);
        
        TreeNode h = new TreeNode(7);
        root.getRight().getRight().setLeft(h);

        System.out.println("LCA : " + LCA(root, b, e).getVal());
        
        System.out.println("LCA : " + LCA(root, f, h).getVal());
        
        System.out.println("LCA : " + LCA(root, b, f).getVal());
        
    }
}
