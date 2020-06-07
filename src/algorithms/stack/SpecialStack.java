/*
 Design a data-structure SpecialStack (using the STL of stack) that supports all the stack operations 
 like push(), pop(), isEmpty() and an additional operation getMinimum() which should return minimum element 
 from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.
 */
package algorithms.stack;

import java.util.Stack;

/**
 *
 * @author Sushanth Bangera
 */
public class SpecialStack {

    private int minElement;
    private Stack<Integer> s = new Stack<>();

    public void push(int a) {
        if (isEmpty()) {
            minElement = a;
            s.push(a);
            return;
        }
        if (a < minElement) {
            s.push(2 * a - minElement);
            minElement = a;
        } else {
            s.push(a);
        }
    }

    public int pop() {
        int returnValue = -1;
        if (isEmpty()) {
            return returnValue;
        }
        int popElement = s.pop();
        if (popElement < minElement) {
            returnValue = minElement;
            minElement = 2 * minElement - popElement;
        } else {
            returnValue = popElement;
        }
        return returnValue;

    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public int getMinimum() {
        return minElement;
    }
    
    public static void main(String[] args)
    {
        SpecialStack s = new SpecialStack();
        
        s.push(3);
        s.push(5);
        int min = s.getMinimum();
        System.out.println("min = " + min);
        s.push(2);
        s.push(1);
        min = s.getMinimum();
        System.out.println("min = " + min);
        s.pop();
        min = s.getMinimum();
        System.out.println("min = " + min);
        s.pop();
    }
}
