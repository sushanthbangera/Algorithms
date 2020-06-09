/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.trees;

/**
 *
 * @author Sushanth Bangera
 */
public class KthLargestElement {

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

    public static void main(String[] args) {

        int arr[] = {1, 5, 6, 2, 9, 3};

        KthLargestElement kle = new KthLargestElement();

        System.out.println("K th largest element: " + kle.findKthLargestElement(arr, 2));

        System.out.println("K th largest element: " + kle.findKthLargestElement(arr, 4));
    }
}
