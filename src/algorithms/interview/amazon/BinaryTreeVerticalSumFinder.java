/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interview.amazon;

import java.util.Map;
import java.util.TreeMap;
import utils.binarytree.BinaryNode;
import utils.binarytree.DNode;

/**
 *               (1)
 *           (2)       (3)
 *       
 *        (4)   (5) (7)  (6)
 *
 * @author Sushanth Bangera
 */
public class BinaryTreeVerticalSumFinder {
    
    public static void main(String[] args) {
        BinaryNode headNode = createTestNode();
        
        // Using Hashing
        Map<Integer, Integer> countMap = new TreeMap<>();
        inOrderVerticalSum(headNode, 0, countMap);
        printVerticalSum(countMap);
        
        
    }
    
    private static void inOrderVerticalSum(BinaryNode currentNode, int horizontalDist, Map<Integer, Integer> countMap) {
        
        if (currentNode == null) {
            return;
        }
        // Left Node
        inOrderVerticalSum(currentNode.getLeft(), horizontalDist - 1, countMap);
        
        // root node or current Node
        int prevSum = countMap.get(horizontalDist) != null ? countMap.get(horizontalDist) : 0;
        countMap.put(horizontalDist, prevSum + currentNode.getData());
        
        // Right Node
        inOrderVerticalSum(currentNode.getRight(), horizontalDist + 1, countMap);
    }
    
    private static void printVerticalSum(Map<Integer, Integer> countMap) {
        countMap.entrySet().forEach(item -> {
            System.out.println(item.getKey() + " - " + item.getValue());
        });
    }
    
    private static void doublyLLVerticalSum() {
        
    }
    
    private static void verticalSumDoublyLLUtil(BinaryNode node, DNode doublyNode) {
        
    }
    
    private static BinaryNode createTestNode() {
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        
        node1.setLeft(node2); 
        node1.setRight(node3);
        
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        
        node2.setLeft(node4); 
        node2.setRight(node5);
        
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        
        node3.setLeft(node7); 
        node3.setRight(node6);
        
        return node1;
    }
}
