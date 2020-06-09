/*
 * https://www.youtube.com/watch?v=13m9ZCB8gjw&t=599s
 * Least Common Ancestor of 2 nodes
 */
package algorithms.trees;

import utils.binarytree.Node;

/**
 *
 * @author Sushanth Bangera
 */
public class LCA {
    
    public static Node LCA (Node root, Node n1, Node n2) {
        
        if (root == null) {
            return null;
        }
        
        if (root == n1 || root == n2) {
            return root;
        }
       
        Node left = LCA (root.getLeft(), n1, n2);
        
        Node right = LCA (root.getRight(), n1, n2);
        
        if (left == null && right == null) {
            return null;
        } 
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public static void main(String[] args) {

        Node root = new Node(3);
        
        Node a = new Node(6);
        root.setLeft(a);
        
        Node b = new Node(2);
        root.getLeft().setLeft(b);
        
        Node c = new Node(11);
        root.getLeft().setRight(c);
        
        Node d = new Node(9);
        root.getLeft().getRight().setLeft(d);
        
        Node e = new Node(5);
        root.getLeft().getRight().setRight(e);
        
        Node f = new Node(8);
        root.setRight(f);
        
        Node g = new Node(13);
        root.getRight().setRight(g);
        
        Node h = new Node(7);
        root.getRight().getRight().setLeft(h);

        System.out.println("LCA : " + LCA(root, b, e).getData());
        
        System.out.println("LCA : " + LCA(root, f, h).getData());
        
        System.out.println("LCA : " + LCA(root, b, f).getData());
        
    }
}
