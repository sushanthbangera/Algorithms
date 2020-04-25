/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edgeverve;

/**
 *
 * @author Sushanth Bangera
 */
public class DecimalToBinaryConvertor {
    
    public static void main(String[] args) {
        int num = 77;
        System.out.println(fourthBit(num));
    }
    
    public static int fourthBit(int number) {
        String inReverseBinary = convertDecToBinary(number);
        if(inReverseBinary.length() >= 4) {
           return Character.getNumericValue(inReverseBinary.charAt(3));
        } else {
           return 0;
        }
    }
    
    public static String convertDecToBinary(int num) {
        StringBuilder str = new StringBuilder();
        while(num > 1) {
            int rem = num % 2;
            str.append(rem);
            num = num/2;       
        }
        str.append(1);
        return str.toString();
    }
}
