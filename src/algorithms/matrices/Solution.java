import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Anils Question
public class Solution {
    public static void main(String args[] ) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//       
//        List<String> elements = new ArrayList<String>(Arrays.asList(input.split("\\s")));
//       
//        String element = br.readLine();
       
        String elemn[] = {"ABC111", "ABC112", "ABC114", "ABC113", "AB222"};
        //List<String> elementsList = Arrays.asList(elemn);
        ArrayList<String> elements = new ArrayList( Arrays.asList(elemn));
        String element = "ABC1";
        
        ElementFinder elementFinder = new LastElement();
        System.out.println("Last element: >" + elementFinder.findElement(elements, element) + "<");
        elementFinder = new FirstElement();
        System.out.println("First element: >" + elementFinder.findElement(elements, element) + "<");
    }
}

interface ElementFinder {
    public String findElement(List<String> list, String element);
}

class FirstElement extends LastElement {
    public String findElement(List<String> list, String element) {
        String result = "";
        String foundElement = super.findElement(list, element);
                
        while(foundElement != "") {
            result = foundElement;
            list.remove(result);
            foundElement = super.findElement(list, element);
        }   
        return result;
    }
}

class LastElement implements ElementFinder {
    public String findElement(List<String> list, String element) {
        int i = list.size() - 1;
        String result = "";
        
        while(i >= 0) {
            if(list.get(i).startsWith(element)) {
                result = list.get(i);
                return result;
            }   
            i--;
        }
        return result;
    }
}