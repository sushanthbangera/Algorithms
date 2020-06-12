/*
 List of toys are given and the list of quotes/sentences about toys are given. And Top Toys Count N is given. We have to find the top N toys appearing in the quotes and list of toys.
       
 Criteria: 
 In a single quote even if the toy word repeats it has to be considered as 1 count.
 If the frequency of the toys are same, they should be sorted based on alphabets.
 If the toys list is greater than the top toys (N), return only N toys, if toys list size is less than or equal to top toys(N)   return the entire list
 */
package algorithms.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Sushanth Bangera
 */
public class ToysAndQuotes {

    public ArrayList<String> getTopToys(List<String> toys, int toysCount,
            int TopToys, List<String> quotes, int qoutesCount) {

        HashMap<String, Integer> toyFreqMap = new HashMap<>();

        toys.forEach((toy) -> {
            quotes.stream().map((quote) -> quote.replace("[^a-zA-Z]", " ").toLowerCase())
                    .filter((quotesInLowerCase) -> (quotesInLowerCase.contains(toy)))
                    .forEach((_item) -> {
                        toyFreqMap.put(toy, toyFreqMap.getOrDefault(toy, 0) + 1);
                    });
        });

        toyFreqMap.entrySet().forEach(it -> {
            System.out.println("toy : " + it.getKey() + " -> freq " + it.getValue());
        });

        // Sorting the map based on frequency value using MaxHeap
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> toyFreqMap.get(b) - toyFreqMap.get(a));
        maxHeap.addAll(toyFreqMap.keySet());

        List<String> toysList = new ArrayList<>();
        while (!maxHeap.isEmpty() && TopToys-- > 0) {
            toysList.add(maxHeap.remove());
        }

        return new ArrayList(toysList);
    }

    public static void main(String[] args) {
        String toysArray[] = {"anacell", "cetracular", "betacellular", "services"};
        String quotes[] = {
            "Anacell provides the best services in the city",
            "betacellular has awesome services",
            "Best services provided by anacell, everyone should use anacell"};

        ArrayList<String> topToys = new ToysAndQuotes().getTopToys(Arrays.asList(toysArray),
                toysArray.length, 2, Arrays.asList(quotes), quotes.length);

        topToys.forEach(toy -> {
            System.out.print(toy + " ");
        });
    }
}
