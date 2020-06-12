/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.scene.layout.Priority;
import utils.Utility;

/**
 *
 * @author Sushanth Bangera
 */
public class FrequentReviewKeywords {

    public static String[] getKFrequencyWords(String[] reviews, String[] keywords) {

        // to get O(1) check
        HashSet<String> keywordsSet = new HashSet<>();
        keywordsSet.addAll(Arrays.asList(keywords));

        HashMap<String, Integer> reviewWordsMap = new HashMap<>();
        for (String review : reviews) {
            // or use regex "[^a-zA-Z]"
            String words[] = review.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");

            for (String word : words) {
                // Add only the keywords into the map
                if (keywordsSet.contains(word)) {
                    reviewWordsMap.put(word, reviewWordsMap.containsKey(word)
                            ? (reviewWordsMap.get(word) + 1) : 1);
                }
            }
        }
        
        //List<String> sortedReviews = getSortedKeys(reviewWordsMap);
        
        List<String> sortedReviews = getSortedKeys2(reviewWordsMap);
        
        String[] resultArray = sortedReviews.toArray(new String[0]);

        return resultArray;
    }
    
    private static List<String> getSortedKeys(HashMap<String, Integer> map) {
        map = sortByValue(map);
        return new ArrayList<>(map.keySet());
    }
    
    // Using the Max Heap to sort the Keys based on the frequency Count
    private static List<String> getSortedKeys2(HashMap<String, Integer> map) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a , b) ->
                    map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        List<String> sortedKeys = new ArrayList<>();
        
        while (!maxHeap.isEmpty()) {
            sortedKeys.add(maxHeap.remove());
        }
        return sortedKeys;
    }
    
    // Sorting the hashmap based on values
    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
       
        List<Map.Entry<String, Integer>> hmList = new LinkedList<>(hm.entrySet());
        
        Collections.sort(hmList, (hm1, hm2) -> {
            int compareValue = hm2.getValue().compareTo(hm1.getValue());
            if (compareValue == 0) {
                return hm1.getKey().compareTo(hm2.getKey());
            }
            return compareValue;
        });
        
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        
        hmList.forEach((entry) -> {
            sortedMap.put(entry.getKey(), entry.getValue());
        });
        
        return sortedMap;
    }
    

    public static void main(String[] args) {
        String keywords[] = {"anacell", "cetracular", "betacellular", "services"};
        String reviews[] = {
            "Anacell provides the best services in the city",
            "betacellular has awesome services",
            "Best services provided by anacell, everyone should use anacell"};
        String[] freqReviews = getKFrequencyWords(reviews, keywords);
        Utility.printArray(freqReviews);
    }
}
