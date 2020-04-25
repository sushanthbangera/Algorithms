/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edgeverve;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Sushanth Bangera
 */
public class RemoveDuplicates {
    
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        boolean noDuplicate = true;
        Scanner sc = new Scanner(System.in);
        //Getting input from console 
        String inputStr = sc.nextLine();

        char[] charArray = inputStr.toCharArray();
        Map<Character, Integer> characterCountMap = new HashMap<>();
        
        for(Character c : charArray) {
            characterCountMap.put(c, characterCountMap.containsKey(c) ? (characterCountMap.get(c) + 1) : 1);
        }
        
       Map<Character, Integer> sortedChartMap = new TreeMap<>(characterCountMap);
       
       for (Map.Entry<Character, Integer> entry : sortedChartMap.entrySet()) {
           if(entry.getValue() == 2) {
               System.out.println(entry.getKey() + " ");
               noDuplicate = false;
           }
	}

        if (noDuplicate) {
            System.out.print("No Duplicate");
        }

    }
}
