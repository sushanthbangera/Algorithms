/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.matrices;

/**
 *
 * @author Sushanth Bangera
 */
public class MatrixRotater {
    
    public static void main(String[] args) {
        
        int mat[][] = { {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}, {26,27,28,29,30}, {31,32,33,34,35}};
        System.out.println("Initial matrix");
        printMatrix(mat, 5);
        System.out.println("Rotated matrix");
        rotateMatrix(mat, 5);
        printMatrix(mat, 5);
    }
    
    public static void rotateMatrix(int mat[][], int n) {
    
        for(int layer = 0; layer < n/2; layer++) {
           
            int first = layer;
            int last = n - layer - 1;
                
            for(int i = first; i < last ; i++) {
               
                int temp = mat[first][first + i];
                
                //left to top
                mat[first][first + i] = mat[last - i][first];
                
                //bottom to left
                mat[last - i][first] = mat[last][last - i];
                
                //right_bottom
                mat[last][last - i] = mat[first + i][last];
                
                //top_right
                mat[first + i][last] = temp;
            }
        }
    }
    
    private static void printMatrix(int mat[][], int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
   
}
