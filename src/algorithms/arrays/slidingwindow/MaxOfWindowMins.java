/*
 * Find maximum of minimum for every window size in a given array
 * 
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
package algorithms.arrays.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sushanth Bangera
 */
public class MaxOfWindowMins {

    /*
     * Time limit exceeded in Leetcode Time: O(N^2) Space: O(1)
     */
    public int maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int min = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                min = Math.min(min, nums[j]);
            }
            maxVal = Math.max(maxVal, min);
        }
        return maxVal;
    }

    /*
     * Time: O(N) Auxilary Space: O(k)
     */
    public int segment(int k, List<Integer> space) {
        int n = space.size();

        // Maintain number in ascending order  
        Deque<Integer> queue = new LinkedList<>();

        int maxOfMins = Integer.MIN_VALUE;
        int i;

        for (i = 0; i < k; i++) {
            // second greatest value is of no use
            while (!queue.isEmpty() && space.get(queue.peekLast()) >= space.get(i)) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        while (i < n) {
            int prevWindowMin = space.get(queue.peek());
            maxOfMins = Math.max(maxOfMins, prevWindowMin);

            // Remove the index from queue if its not part of current sliding window 
            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && space.get(queue.peekLast()) >= space.get(i)) {
                queue.removeLast();
            }
            queue.addLast(i);
            i++;
        }

        int prevWindowMin = space.get(queue.peek());
        maxOfMins = Math.max(maxOfMins, prevWindowMin);

        return maxOfMins;
    }
    
    public int maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;

        // Maintain number in ascending order  
        Deque<Integer> queue = new LinkedList<>();

        int maxOfMins = Integer.MIN_VALUE;
        int i;

        for (i = 0; i < k; i++) {
            // second greatest value is of no use
            while (!queue.isEmpty() && nums[queue.peekLast()] >= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        
        while (i < n) {
            int prevWindowMin = nums[queue.peek()];
            maxOfMins = Math.max(maxOfMins, prevWindowMin);

            // Remove the index from queue if its not part of current sliding window 
            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] >= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            i++;
        }
        int prevWindowMin = nums[queue.peek()];
        maxOfMins = Math.max(maxOfMins, prevWindowMin);

        return maxOfMins;
    }
    
    public static void main(String[] args) {
        
        int arr1[] = {8, 2, 4};
        
        Integer arr[] = {10000};
        List<Integer> list = Arrays.asList(arr);
        
        MaxOfWindowMins mw = new MaxOfWindowMins();
        System.out.println("max min: " + mw.maxSlidingWindow2(arr1, 2));
        
        System.out.println("max min: " + mw.segment(1, list));
    }
}
