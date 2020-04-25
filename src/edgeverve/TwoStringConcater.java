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
public class TwoStringConcater {
    
    public static void main(String[] args) {
        
        String s1 = "abc";
        String s2 = "bcdf";
        
        System.out.println(twoStringConcator(s1, s2));
    }
    
    /*
    Concatenation of the Strings in the aplhabetical order
    */
    public static String twoStringConcator(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        StringBuilder str = new StringBuilder();
        
        if(len1 > len2) {
            for(int i = 0; i < len2; i++) {
                str.append(str1.charAt(i)).append(str2.charAt(i));
            }
            str.append(str1.substring(len2, len1));
        } else {
            for(int i = 0; i < len1; i++) {
                str.append(str1.charAt(i)).append(str2.charAt(i));
            }
            str.append(str2.substring(len1, len2));
        }
        
        return str.toString();
    }
    
    
            
}
