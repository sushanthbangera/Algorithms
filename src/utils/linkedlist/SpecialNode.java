/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.linkedlist;

/**
 *
 * @author Sushanth Bangera
 */
public class SpecialNode {
    
    private Integer data;
    
    private SpecialNode next;
    
    private SpecialNode random;

    public SpecialNode(Integer data) {
        this.data = data;
    }
    
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public SpecialNode getNext() {
        return next;
    }

    public void setNext(SpecialNode next) {
        this.next = next;
    }

    public SpecialNode getRandom() {
        return random;
    }

    public void setRandom(SpecialNode random) {
        this.random = random;
    }
    
    public static void printLinkedList(SpecialNode head) {
        SpecialNode currentNode = head;
       
        while (currentNode != null) {
            System.out.println(currentNode.getData() + " Random: " + (currentNode.getRandom() != null? currentNode.getRandom().getData() : null));
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }
    
}
