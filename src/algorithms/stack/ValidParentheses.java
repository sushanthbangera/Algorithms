/*
 Given a string containing just the characters '(', ')', '{', '}', '[', ']',
 determine if the String is valid

 Thebracjets must close in the correct order, "()" and "()[]{}" are all valid but
 "(]" and ({) are not valid.
 */
package algorithms.stack;

import java.util.Stack;

/**
 *
 * @author Sushanth Bangera
 */
public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack<Character> pStack = new Stack<>();

        for (char c : str.toCharArray()) {
            switch (c) {
                case '(':
                    pStack.push(')');
                    break;
                case '{':
                    pStack.push('}');
                    break;
                case '[':
                    pStack.push(']');
                    break;
                default:
                    if (pStack.isEmpty() || pStack.pop() != c) {
                        return false;
                    }
            }
        }
        return pStack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({[]})(";
        System.out.println(isValid(str));
    }
}
