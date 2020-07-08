/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.binarytree;

/**
 *
 * @author Sushanth Bangera
 * @param <U>
 * @param <V>
 */
public class Pair<U, V> {
    
    public final U first;
    
    public final V second;
    
    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
    
    public static <U, V> Pair <U, V> of (U first, V second) {
        return new Pair<>(first, second);
    }
}
