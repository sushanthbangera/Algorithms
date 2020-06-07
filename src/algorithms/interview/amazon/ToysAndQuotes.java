/*
 List of toys are given and the list of quotes/sentences about toys are given. And Top Toys Count N is given. We have to find the top N toys appearing in the quotes and list of toys.
       
 Criteria: 
 In a single quote even if the toy word repeats it has to be considered as 1 count.
 If the frequency of the toys are same, they should be sorted based on alphabets.
 If the toys list is greater than the top toys (N), return only N toys, if toys list size is less than or equal to top toys(N)   return the entire list
 */
package algorithms.interview.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sushanth Bangera
 */
public class ToysAndQuotes {
    
    public ArrayList<String>  getTopToys(List<String> toys, int toysCount,
            int TopToys, List<String> quotes, int qoutesCount) {
        
        HashMap<String, Integer> toyFreqMap = new HashMap<>();
        
        for (String toy : toys) {
            for (String quote : quotes) {
                String quotesInLowerCase = quote.replace("[^a-zA-Z]", " ").toLowerCase();
                // String has contains() method as well -> quotesInLowerCase.contains(toy)
                if (quotesInLowerCase.indexOf(toy) > 0) {
                    if (toyFreqMap.containsKey(toy)) {
                        toyFreqMap.put(toy, toyFreqMap.get(toy) + 1);
                    } else {
                        toyFreqMap.put(toy, 1);
                    }
                }
            }
        }
        
        // Sorting the map based on frequency value
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(toyFreqMap.entrySet());
        
        Collections.sort(entryList, (entry1, entry2) -> {
            int compareValue = entry2.getValue().compareTo(entry1.getValue());
            if(compareValue == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return compareValue;
        });
        
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        entryList.forEach(item -> {
            sortedMap.put(item.getKey(), item.getValue());
        });
        
        List<String> toysList = new ArrayList<>(sortedMap.keySet());
        
        if(toysList.size() > TopToys) {
            toysList = toysList.subList(0, TopToys);
        }
        
        return new ArrayList(toysList);
    }
}
