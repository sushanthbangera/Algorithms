/*
 Given a substring find the length of the longest substring 
 without repeating characters
 */
package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sushanth Bangera
 */
public class LongestSubstring {

    private static int getLengthofLongestSubString(String s) {
        int maxSubStrLen = 0;
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        Map<Character, Integer> chMap = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            Character ch = s.charAt(i);
            if (chMap.containsKey(ch)) {
                j = Math.max(j, chMap.get(ch) + 1);
            }
            chMap.put(ch, i);
            maxSubStrLen = Math.max(maxSubStrLen, i - j + 1);
        }
        return maxSubStrLen;
    }

    public static void main(String[] args) {
        String s = "abcasccadkl";
        System.out.println(getLengthofLongestSubString(s));
    }
}
