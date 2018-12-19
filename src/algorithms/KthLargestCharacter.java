/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author Sushanth Bangera
 */
public class KthLargestCharacter {
    
    public static void main(String[] args) {
        Map<Character, Integer> charMap = new HashMap<>();
        int k = 2;
        int kthLargestElement = -1;
        
        String s = "aabcd";
        int charLength = s.length();
        for(int i = 0; i < charLength; i++) {
            int count = 1;
            char a = s.charAt(i);
            if(charMap.containsKey(a)) {
                count = charMap.get(a) + 1;
            }
            charMap.put(a, count);
        }
        TreeSet<Integer> valuesList = new TreeSet<>();
        
        charMap.entrySet().forEach(item -> {
            valuesList.add(item.getValue());
        });
        
        ArrayList<Integer> listVal = new ArrayList<>();
        listVal.addAll(valuesList);
        
        Integer array[] = listVal.toArray(new Integer[0]);
        
        TreeSet<Character> trees = new TreeSet<>();
        int size = array.length;
        
        if(size >= k) {
            kthLargestElement = array[size - k];
        }
        System.out.println("kavl == " + kthLargestElement);
        if (kthLargestElement != -1) {
            for (Map.Entry<Character, Integer> item : charMap.entrySet()) {
                if (item.getValue() == kthLargestElement) {
                    trees.add(item.getKey());
                }
            }
            System.out.println(trees.toArray()[0]);
        } else {
            System.out.println(-1);
        }
    }
}
