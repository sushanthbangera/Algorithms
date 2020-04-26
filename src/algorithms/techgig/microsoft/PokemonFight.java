package algorithms.techgig.microsoft;


import java.util.Arrays;
import utils.Utility;

/*
 * fight the battle with pokemons such that you win the maximum battles.
 * To win the battle your pokemon power should be strictly geater than the opposition power.
 * You know the Opposition teams pokemon powers as well as your teams.
 * You should arrange your players in such a way that you win the maximum battles.
 * 
 */

/**
 *3 6 7 5 3 5 6 2 9 1 
2 7 0 9 3 6 0 6 2 6 
 * @author Sushanth Bangera
 */
public class PokemonFight {
    
    public static void main(String[] args) {
       
        int playerCount = 10;
        int arr1[] = {3, 6, 7, 5, 3, 5, 6, 2, 9, 1};
        int arr2[] = {2, 7, 0, 9, 3, 6, 0, 6, 2, 6};
        
        findMaxwins(arr1, arr2, playerCount);
        findMaxwins(arr2, arr1, playerCount);
        
        int arr3[] = {1, 2, 3, 4, 5};
        int arr4[] = {3, 4, 5, 6, 7};
        
        findMaxwins(arr3, arr4, arr3.length);
        findMaxwins(arr4, arr3, arr3.length);
       
    }
    
    private static void findMaxwins(int arr1[], int arr2[], int playerCount) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        Utility.printArray(arr1);
        System.out.println("");
        Utility.printArray(arr2);
        
        int i = 0;
        int j = 0;
        int maxwins = 0;
        
        while (i < playerCount && arr1[i] > arr2[j]) {
            i++;
            j++;
            maxwins++;
        }
        
        while (i < playerCount - 1) {
            i++;
            if (arr1[i] > arr2[j]) {
                j++;
                maxwins++;
            }
        }
       System.out.println("");
       System.out.println("Maxwins : " + maxwins);
    }
}
