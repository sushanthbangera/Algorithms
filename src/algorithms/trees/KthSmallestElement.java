/*
 * Finding the Kth Smallest element using Min Heap
 * 
 * 
 */
package algorithms.trees;

import java.util.PriorityQueue;

/**
 *
 * @author Sushanth Bangera
 */
public class KthSmallestElement {

    public int findKthSmallestElement(int arr[], int K) {

        int arrSize = arr.length;

        MinHeap minHeap = new MinHeap(arrSize);

        for (int a : arr) {
            minHeap.insert(a);
        }

        for (int i = K; i > 1; i--) {
            minHeap.poll();
        }

        return minHeap.poll();
    }
    
    public int findKthSmallestElement2(int arr[], int K) {
        
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        
        for (int i : arr) {
            intQueue.add(i);
        }

        for (int i = K; i > 1; i--) {
            intQueue.remove();
        }

        return intQueue.remove();
    }

    public static void main(String[] args) {

        int arr[] = {1, 5, 6, 2, 9, 3};

        KthSmallestElement kse = new KthSmallestElement();

        System.out.println("Kthe smallest element: " + kse.findKthSmallestElement(arr, 4));

        System.out.println("Kthe smallest element: " + kse.findKthSmallestElement2(arr, 4));
        
        System.out.println("Kthe smallest element: " + kse.findKthSmallestElement(arr, 3));

        System.out.println("Kthe smallest element: " + kse.findKthSmallestElement2(arr, 3));
    }
}
