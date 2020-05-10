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
public class ParkCounter {

    final static int[] offsets = {-1, 0, +1};

    private boolean neighborExists(int[][] matrix, int i, int j) {
        if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length)) {
            if (matrix[i][j] == 1) {
                return true;
            }
        }
        return false;
    }

    private void doDFS(int[][] matrix, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        int xOffset, yOffset;
        for (int l = 0; l < offsets.length; l++) {
            xOffset = offsets[l];
            for (int m = 0; m < offsets.length; m++) {
                yOffset = offsets[m];

                if (xOffset == 0 && yOffset == 0 || xOffset == 0 && yOffset == 1) {
                    continue;
                }

                if (neighborExists(matrix, i + xOffset, j + yOffset)) {
                    doDFS(matrix, i + xOffset, j + yOffset, visited);
                }
            }
        }
    }

    public int findNumberofClusters(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((matrix[i][j] == 1) && (!visited[i][j])) {

                    count += 1;
                    doDFS(matrix, i, j, visited);
                }
            }
        }
        return count;
    }

    boolean isSafe(int M[][], int row, int col,
            boolean visited[][]) {
        // row number is in range, column number is in range 
        // and value is 1 and not yet visited 
        return (row >= 0) && (row < 5) && (col >= 0) && (col < 4) && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix. 
    // It only considers the 8 neighbors as adjacent vertices 
    void DFS(int M[][], int row, int col, boolean visited[][]) {
        // These arrays are used to get row and column numbers 
        // of 8 neighbors of a given cell 
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited 
        visited[row][col] = true;

        // Recur for all connected neighbours 
        for (int k = 0; k < 8; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    // The main function that returns count of islands in a given 
    // boolean 2D matrix 
    int countIslands(int M[][], int ROW, int COL) {
        // Make a bool array to mark visited cells. 
        // Initially all cells are unvisited 
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells 
        // of given matrix 
        int count = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with 
                { // value 1 is not 
                    // visited yet, then new island found, Visit all 
                    // cells in this island and increment island count 
                    DFS(M, i, j, visited);
                    ++count;
                }
            }
        }

        return count;
    }

    
    int numberOfIslands(int mat[][]) {
        
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                
                if (mat[i][j] == 1) {
                    count+=1;
                    BFS(mat, i, j);
                }
            }
        }
        return count;
        
    }
    
    private void BFS(int mat[][], int i, int j) {
        
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || mat[i][j] == 0) {
            return;
        } 
        mat[i][j] = 0;
        BFS(mat, i + 1, j);
        BFS(mat, i - 1, j);
        BFS(mat, i, j - 1);
        BFS(mat, i, j + 1);
    }
    
    public static void main(String[] args) {

        int row = 5, column = 4;
        int cluster = 0;

        int mat[][] = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {1, 0, 1, 1}, {1, 1, 1, 1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

        System.out.println(new ParkCounter().numberOfIslands(mat));
       // System.out.println(new ParkCounter().countIslands(mat, row, column));
    }
}
