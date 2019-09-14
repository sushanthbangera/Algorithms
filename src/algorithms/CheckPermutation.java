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
public class CheckPermutation {
    
    public static void main(String[] args) {
        String str1 = "algorithm";
        String str2 = "mhtalogri";
        
        System.out.println("The two string are " + (isPermuatation(str1, str2) ? "" : "not ") + "permutations of each other");
        System.out.println("The two string are " + (isPermuatation_2(str1, str2) ? "" : "not ") + "permutations of each other");
        //System.out.println("The two string are " + (isPermuatation(str1, str2) ? "" : "not ") + "permutations of each other");
        
        str1 = "algorithm";
        str2 = "mhtalogrs";
        
        System.out.println("The two string are " + (isPermuatation(str1, str2) ? "" : "not ") + "permutations of each other");
        System.out.println("The two string are " + (isPermuatation_2(str1, str2) ? "" : "not ") + "permutations of each other");
    }
    
    // This solution is using the ASCII values of the characters
    // If sum of the ascii values are equal, then both strings have same characters
    public static boolean isPermuatation(String str1, String str2) {
        int str1_len = str1.length();
        // if the length of the strings are not equal they can't be the permutation of each other
        if(str1_len != str2.length()) {
            return false;
        }
        int str1_sum = 0, str2_sum = 0;
        for(int i = 0; i < str1_len; i++) {
            str1_sum += str1.charAt(i);
            str2_sum += str2.charAt(i);
        }
        return str1_sum == str2_sum;
    }
    
    //-------- Second Solution is converting the string to caharcter array and sorting it.
    // after sorting if the two strings are equal, then they are permutations of each other
    public static boolean isPermuatation_2(String str1, String str2) {
        int str1_len = str1.length();
        // if the length of the strings are not equal they can't be the permutation of each other
        if(str1_len != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }
    
    public static String sort(String str) {
        char[] chs = str.toCharArray();
        java.util.Arrays.sort(chs);
        return new String(chs);
    }
    // ------------- The second solution ends here -------------
}
