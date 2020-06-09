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
public class MinHeap {

    // will be storing from position 1
    private int arr[];

    private int heapSize;

    public MinHeap(int size) {
        this.arr = new int[size + 1];
        this.heapSize = 0;
    }

    public void insert(int data) {
        arr[heapSize + 1] = data;
        this.heapSize++;
        heapifyBottomToTop(heapSize);
        printHeap();
    }

    public int poll() {
        if (heapSize == 0) {
            return -1;
        } else {
            int topElement = arr[1];
            System.out.println("Extracting the element: " + topElement);
            arr[1] = arr[heapSize];
            //arr[heapSize] = 0;
            heapSize--;
            heapifyTopToBottom(1);
            printHeap();
            return topElement;
        }
    }

    private void heapifyTopToBottom(int index) {

        int left = index * 2;
        int right = (index * 2) + 1;
        int smallestElementIndex = 0;

        if (heapSize < left) {
            return;
        } else if (heapSize == left) {
            if (arr[index] > arr[left]) {
                swap(index, left);
            }
            return;
        } else {
            smallestElementIndex = (arr[left] < arr[right]) ? left : right;

        }
        if (arr[index] > arr[smallestElementIndex]) {
            swap(smallestElementIndex, index);
        }
        heapifyTopToBottom(smallestElementIndex);
    }

    private void heapifyBottomToTop(int index) {

        int parent = index / 2;

        if (index <= 1) {
            return;
        }

        if (arr[index] < arr[parent]) {
            swap(parent, index);
        }
        heapifyBottomToTop(parent);
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void printHeap() {
        for (int i = 1; i <= heapSize; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println();
    }
}
