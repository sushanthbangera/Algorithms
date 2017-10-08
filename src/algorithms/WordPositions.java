/*
 Program to store the first index of every word in a given syntax
*/
package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sushanth Bangera
 */
public class WordPositions {

    private static final Map<String, ArrayList<Integer>> wordMap = new HashMap<>();

    public static void storeWordPositions(String inStr) {
        int indexPos = 0;
        String words[] = inStr.split("\\s+");
        ArrayList<Integer> posList;
        for (String word : words) {
            posList = wordMap.containsKey(word) ? wordMap.get(word) : new ArrayList<>();
            posList.add(indexPos);
            wordMap.put(word, posList);
            indexPos += word.length() + 1; // +1 is for the space count
        }
    }

    public static void printMap() {
        wordMap.entrySet().stream().forEach((item) -> {
            System.out.print(item.getKey() + ": ");
            item.getValue().forEach((pos) -> {
                System.out.print(pos + ",");
            });
            System.out.println("");
        });
    }

    public static void main(String[] args) {
        String str = "the song is the best song";
        storeWordPositions(str);
        printMap();
    }

}
