/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edgeverve;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Sushanth Bangera
 */
public class HashTest {
    
    public static void main(String[] args) {
        Set<Employee> hset = new HashSet<>();    
        Scanner s = new Scanner(System.in);
        String inputValues = s.nextLine();
        
        String[] values = inputValues.split("\\s");
        for (String v: values) {
            hset.add(new Employee(Integer.parseInt(v)));
        }
        System.out.println(hset.size());      
        
        s.close();
    }
}
