/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.micorsoft;

import java.util.HashMap;
import java.util.Map;
import utils.linkedlist.SpecialNode;

/**
 *
 * Clone a doubly linked list which has next and arbitrary pointer
 * @author Sushanth Bangera
 */
public class DoublyLinkedListCloner {
    
    public static void main(String[] args) {
        
        SpecialNode a = new SpecialNode(1);
        SpecialNode b = new SpecialNode(2);
        SpecialNode c = new SpecialNode(3);
        SpecialNode d = new SpecialNode(4);
        
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        
        a.setRandom(c);
        b.setRandom(d);
        c.setRandom(a);
        d.setRandom(b);
       
       SpecialNode.printLinkedList(a);
       
       SpecialNode clonedHead = cloneLinkedList(a);
       SpecialNode.printLinkedList(clonedHead);
       
       Map<SpecialNode, SpecialNode> nextPointersMap = storeNextOfOriginalList(a);
       
       changeNextPointerOfOriginal(a, clonedHead, nextPointersMap);
       SpecialNode.printLinkedList(clonedHead);
       
       setRandomPointersForClonedList(clonedHead);
       SpecialNode.printLinkedList(clonedHead);
    }
    
    public static SpecialNode cloneLinkedList(SpecialNode head) {
        
        SpecialNode currentNode = head;
        SpecialNode headNode = null;
        SpecialNode newNode = null;
        SpecialNode prevNode = null;
        
        while (currentNode != null) {
            newNode = new SpecialNode(currentNode.getData());
            
            if (headNode == null) {
                headNode = newNode;
            }
            if (prevNode != null) {
                prevNode.setNext(newNode);
            }
            prevNode = newNode;
            currentNode = currentNode.getNext();
        }
        return headNode;
    }
    
    private static Map<SpecialNode, SpecialNode>  storeNextOfOriginalList(SpecialNode oldHead) {
        Map<SpecialNode, SpecialNode> oldNextMap = new HashMap<>();
        SpecialNode currentNode = oldHead;
        
        while (currentNode != null) {
            oldNextMap.put(currentNode, currentNode.getNext());
            currentNode = currentNode.getNext();
        }
        return oldNextMap;
    }
    
    private static void changeNextPointerOfOriginal(SpecialNode originalHead, SpecialNode newHead, Map<SpecialNode, SpecialNode> nextNodesMap) {
        
        SpecialNode currentOriginalNode = originalHead;
        SpecialNode currentNewNode = newHead;
        
        while(currentOriginalNode != null) {
            currentOriginalNode.setNext(currentNewNode);
            currentNewNode.setRandom(currentOriginalNode);
            currentNewNode = currentNewNode.getNext();
            currentOriginalNode = nextNodesMap.get(currentOriginalNode); // next is already updated so take from map for old next
        }
    }
    
    private static void setRandomPointersForClonedList(SpecialNode newHead) {
        SpecialNode currentNewNode = newHead;
        
        while (currentNewNode != null) {
            currentNewNode.setRandom(currentNewNode.getRandom().getRandom().getNext());
            currentNewNode = currentNewNode.getNext();
        }
    }
}
