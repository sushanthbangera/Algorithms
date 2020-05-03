/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interview.amazon;

import java.util.LinkedList;
import java.util.Queue;
import utils.binarytree.BinaryNode;

/**
 * (1) (2) (3)
 *
 * (4) (5) (6) (7)
 *
 * @author Sushanth Bangera
 */
public class BinaryTreeMaximumWidth {

    public static void main(String[] args) {
        BinaryNode headNode = createTestNode();

        System.out.println("Max Width : " + calculateMaximumWidth(headNode));
        
        System.out.println("Max Width : " + calculateMaximumWidth_2(headNode));
    }

    // Using two queues
    public static int calculateMaximumWidth(BinaryNode headNode) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(headNode);

        Queue<BinaryNode> childqueue = new LinkedList<>();

        int maxWidth = 1;

        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();

            if (currentNode.getLeft() != null) {
                childqueue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                childqueue.add(currentNode.getRight());
            }

            if (queue.isEmpty() && !childqueue.isEmpty()) {
                maxWidth = Math.max(maxWidth, childqueue.size());
                queue.addAll(childqueue);
                childqueue.clear();
            }

        }
        return maxWidth;
    }

    // using one queue
    public static int calculateMaximumWidth_2(BinaryNode headNode) {

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(headNode);

        int maxWidth = 0;

        while (!queue.isEmpty()) {

            int count = queue.size();

            maxWidth = Math.max(count, maxWidth);

            while (count-- > 0) {
                BinaryNode currentNode = queue.remove();

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
        }
        return maxWidth;
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
