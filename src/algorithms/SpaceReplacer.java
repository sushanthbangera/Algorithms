/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Sushanth Bangera
 */
public class SpaceReplacer {
    
    public static void main(String[] args) {
        String str = "My name is Antony    ";
        System.out.println("Input String: " + str);
        String replaceString = "%20";
        
        System.out.println("String after replacement of spcae: " + replaceSpace(str, replaceString));
    }
    
    public static String replaceSpace(String str, String replaceStr) {
        String newStr = "";
        char[] ch_array = str.toCharArray();
        int strLen = str.length();
        
        for(int i = 0; i < strLen; i++) {
            if((ch_array[i] + "").equals(" ")) {
                newStr += replaceStr;
            } else {
                newStr += ch_array[i];
            }
        }
        return newStr;
    }
}
