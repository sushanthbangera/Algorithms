/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.arrays;
//Select a.name, b.price from customer a left join Order b on (a.id = b.id)
        //where b.price = (select max(price) from orders where b.order_date < (Select DATEADD(year, 10, (select min(order_date) from orde
import java.util.Scanner;

/**
 *
 * @author Sushanth Bangera
 */
public class AntAndTermites {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String input = in.next();
        
        System.out.println(getWinner(count, input));

    }
    
    public static String getWinner(int count, String insects) {
    
        char[] ch = insects.toCharArray();
        int n = ch.length;
        
        int antCount = 0;
        int termiteCount = 0;
        
        for(int i = 0; i < n; i++) {
            
            switch(ch[i]) {
                case 'A' :
                    antCount++;
                    break;
                case 'T' :
                    if(i > 0 && ch[i - 1] == 'A') {
                    antCount--;
                     } 
                termiteCount++;
                    break;
            }
        }
        
        if(antCount == termiteCount) {
            return "Tie";
        } else if (antCount > termiteCount) {
            return "Ants";
        } else {
            return "Termites";
        }
       
        
    }
}
