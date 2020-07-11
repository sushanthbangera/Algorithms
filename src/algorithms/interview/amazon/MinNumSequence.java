/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interview.amazon;

/**
 * https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 *
 * @author Sushanth Bangera
 */
public class MinNumSequence {

    public int[] minNumber(String input) {

        int len = input.length();
        int result[] = new int[len + 1];
        result[0] = 1;

        int nextNumber = 2;
        int prevIncIndex = 0;

        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == 'I') {
                result[i + 1] = nextNumber;
                prevIncIndex = i + 1;
            } else {
                result[i + 1] = result[i];// copy the prev element to current Postion
                //increment the numbers from prev Increment Index
                for (int j = prevIncIndex; j <= i; j++) {
                    result[j]++;
                }
            }
            nextNumber++;
        }
        return result;
    }

    public static void main(String[] args) {

        String a = "IDDID";

        MinNumSequence mns = new MinNumSequence();
        utils.Utility.printArray(mns.minNumber(a));

        System.out.println();
        String b = "I";
        utils.Utility.printArray(mns.minNumber(b));

        System.out.println();
        String c = "D";
        utils.Utility.printArray(mns.minNumber(c));

        System.out.println();
        String d = "DI";
        utils.Utility.printArray(mns.minNumber(d));

        System.out.println();
        String e = "DD";
        utils.Utility.printArray(mns.minNumber(e));

        System.out.println();
        String f = "DDIDDIID";
        utils.Utility.printArray(mns.minNumber(f));
    }
}
