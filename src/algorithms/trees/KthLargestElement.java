/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

import java.util.PriorityQueue;

/**
 *
 * @author Sushanth Bangera
 */
public class KthLargestElement {

    /*
    Storing all elements in Max Heap and poll till kth item in Heap
    */
    public int findKthLargestElement(int arr[], int K) {

        int arrSize = arr.length;

        MaxHeap maxHeap = new MaxHeap(arrSize);

        for (int a : arr) {
            maxHeap.insert(a);
        }

        for (int i = K; i > 1; i--) {
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
    
    /*
    Min heap to solve this problem. heap stores the top k largest elements
    The top of the heap is the Kth Largest element and all other elements 
    are greater than the heap top. 
    Whenever the size is greater than k, delete the min. 
    Time: O(nlog(k)). // every insert is log(k)
    Space: O(k) for storing the top k numbers
    */
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {

        int arr[] = {1, 5, 6, 2, 9, 3, 10};

        KthLargestElement kle = new KthLargestElement();

        System.out.println("K th largest element: " + kle.findKthLargestElement(arr, 2));

        System.out.println("K th largest element: " + kle.findKthLargestElement(arr, 4));
        
        System.out.println("K th largest element: " + kle.findKthLargest(arr, 4));
    }
}
