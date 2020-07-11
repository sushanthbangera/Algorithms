/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.interview.amazon;

/**
 *
 * @author Sushanth Bangera
 */
public class LargestConnectedArea {

    public static int largestConnectedRegion(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int maxRegion = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && grid[i][j] != -1 && grid[i][j] != 0) {
                    int count = DFS(grid, i, j);
                    maxRegion = Math.max(count, maxRegion);
                }
            }
        }
        return maxRegion;
    }

    private static int DFS(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        // mark the grid visited
        grid[i][j] = 0;
        int count = 1;
        
        // {top diagonal left, top, top diagonal right, left, right, 
        // bootom diagonal left, bottom, bottom diagonal right}
//        int rowMoves[] = {-1, -1, -1, 0, 0, 1, 1, 1};
//        int columnMoves[] = {-1, 0, 1, -1, 1, -1, 0, 1};
//
//        for (int k = 0; k < 8; k++) {
//           count += DFS(grid, i + rowMoves[k], j + columnMoves[k]);
//        }

        // above interation uses extra space
        for (int row = i - 1; row <= i + 1; row++) {
            for (int column = i - 1; column <= j + 1; column++) {
                if (row != i || column != j) {
                    count += DFS(grid, row, column);
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int M[][] = 
                {
                    {0, 0, 1, 1, 0},
                    {1, 0, 1, 1, 0},
                    {0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 1}
                };

        System.out.println(largestConnectedRegion(M));
    }
}
