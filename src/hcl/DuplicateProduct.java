/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sushanth Bangera
 */
public class DuplicateProduct {
    
    public static void main(String[] args) {
        
        String name[] = {"ball", "box", "ball", "ball", "box"};
        int price[] = {2, 2, 2, 2, 2};
        int weight[] = {1, 2, 1, 1, 3};
        
        int len = name.length;
        
        Set<Product> prodSet = new HashSet<>();
        
        for(int i = 0; i < len; i++) {
            Product a = new Product(name[i], price[i], weight[i]);
            prodSet.add(a);
        }
        
        int duplicates = len - prodSet.size();
        System.out.println(duplicates);
    }
}


class Product {
    String name;
    int price;
    int weight;
    
    public Product(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
    
    @Override
    public boolean equals(Object o) {
        Product prod = (Product) o;
        if (prod.getName().equals(this.getName()) && (prod.getPrice() == this.getPrice()) && (prod.getWeight() == this.getWeight())) {
            return true;
        }
        return false;
    }
 
    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getPrice() + this.getWeight();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
}