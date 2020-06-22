
package utils;

/**
 *
 * @author Sushanth Bangera
 */
public class Utility {
    
    public static void printArray(int arr[]) {
        for(int a : arr) {
            System.out.print(a + " ");
        }
    }
    
    public static void printArray(Long arr[]) {
        for(Long a : arr) {
            System.out.print(a + " ");
        }
    }
    
    public static void printArray(String arr[]) {
        for (String a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    
    public static <T> void printArray(T arr[]) {
        for (T a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void printArray(char arr[]) {
        for (char a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
