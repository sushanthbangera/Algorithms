/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.linkedlist;

import utils.linkedlist.DoubleNode;

/**
 *
 * @author Sushanth Bangera
 */
public class DoublyLinkedListSortedInsert {
    
    public static void main(String[] args) {
        
        /*
        Test cases
        1. adding same number
        2. Lesser than the 1st number
        3. grater than all the numbers
        4. Same number as last number
        5. same number as first number
        */
        
        DoubleNode a = new DoubleNode(1);
        DoubleNode b = new DoubleNode(3);
        a.next = b;
        b.prev = a;
        
        DoubleNode c = new DoubleNode(5);
        b.next = c;
        c.prev = b;
        
        DoubleNode d = new DoubleNode(10);
        c.next = d;
        d.prev = c;
        
        printNode(a);
        
        DoubleNode x = sortedInsert(a, 1);
        printNode(x);
        
    }
    
    static DoubleNode sortedInsert(DoubleNode head, int data) {

        DoubleNode currentNode = head;
        DoubleNode prevNode = null;
        while (currentNode != null) {
            prevNode = currentNode.prev;
            if (currentNode.data > data) {
                
                DoubleNode newNode = new DoubleNode(data);

                newNode.prev = currentNode.prev;
                newNode.next = currentNode;
                currentNode.prev = newNode;
                if (prevNode != null) {
                    prevNode.next = newNode;  
                } else {
                    head = newNode;
                }

                return head;
            }
            currentNode = currentNode.next;
        }
        // if the number is grater than all the number it has to be inserted in the end
        if(currentNode == null && (prevNode != null && prevNode.next.data <= data)) {
            DoubleNode newNode = new DoubleNode(data);
            currentNode = prevNode.next;
            currentNode.next = newNode;
            newNode.prev = currentNode;
            return head; 
        }
        return head;
    }
    
    
    static void printNode(DoubleNode head) {
        
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
