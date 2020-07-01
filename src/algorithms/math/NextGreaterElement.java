/*
 * https://www.geeksforgeeks.org/next-greater-element/
 * 
 */
package algorithms.math;

import java.util.Stack;

/**
 *
 * @author Sushanth Bangera
 */
public class NextGreaterElement {
    
    public int[] nextGreaterElement(int[] nums) {
        
        int len = nums.length;
        
        int result[] = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] n = {1, 2, 4, 5};
        NextGreaterElement nge = new NextGreaterElement();
        utils.Utility.printArray(nge.nextGreaterElement(n));
        
        System.out.println();
        int[] n1 = {1, 6, 4, 5};
        utils.Utility.printArray(nge.nextGreaterElement(n1));
     }
}
