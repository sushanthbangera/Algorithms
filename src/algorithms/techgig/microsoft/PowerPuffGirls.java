package algorithms.techgig.microsoft;


import java.util.Scanner;

/*
 * To fight the deamons, the powerpuff girls are to be created by a scientist
 * For creating one powerpfuff girl there are specifications of ingredients
 * The totol qauntity of ingrdients and the ingredients required to create one power puff girl would be provided.
 * Task is to find the maximum no of powerpuff girls that can be created out of it
 */

/**
 *
 * @author Sushanth Bangera
 */
public class PowerPuffGirls {
    
    public static void main(String args[] ) throws Exception {

    	Scanner sc = new Scanner(System.in);
        int ingNum = sc.nextInt();
        int arrReq[] = new int[ingNum];
        int arrAvailable[] = new int[ingNum];

        for(int i = 0; i < ingNum; i++) {
            arrReq[i] = sc.nextInt();
        }

        for(int i = 0; i < ingNum; i++) {
            arrAvailable[i] = sc.nextInt();
        }

        Integer min = Integer.MAX_VALUE;

        for (int i = 0; i < ingNum; i++) {
            Integer possible = arrAvailable[i] / arrReq[i];
            min = Math.min(min, possible);
        }

        System.out.print(min);
   }
}
