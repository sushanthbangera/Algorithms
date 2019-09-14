/*
 * Algorithm to determine if a string has all unique characters
 * 
 */
package algorithms;

/**
 *
 * @author Sushanth Bangera
 */
public class UniqueCharacters {
    
    public static void main(String[] args) {
        String str = "sushanth";
        System.out.println("The characters in the string '" + str +"' are " + (isUniqueCharacters(str) ? "unique" : "not unique"));
        
        str = "suanth";
        System.out.println("The characters in the string '" + str +"' are " + (isUniqueCharacters(str) ? "unique" : "not unique"));
    }

    public static boolean isUniqueCharacters(String str) {
        int len = str.length();
        // if the word length is greater than the unique characters
        if(len > 26) return false;
        
        boolean arr[] = new boolean[26];
        for(int i = 0; i < len; i++) {
            int ascii = str.charAt(i);
            if(arr[ascii - 'a']) {
                return false;
            }
            arr[ascii - 'a'] = true;
        }
        return true;
    }

}
