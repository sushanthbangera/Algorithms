/*
 * Given a cost matrix, find the minimum cost to reach bottom right from top left
 */
package algorithms.interview.amazon;

/**
 *
 * @author Sushanth Bangera
 */
public class MinimumCostMatrix {

    // using index 1 to m using recursion
    public int getMinimumCost(int mat[][], int row, int col) {

        if (row == -1 || col == -1) {
            return Integer.MAX_VALUE;
        }

        if (row == 0 && col == 0) {
            return mat[0][0];
        }

        int fromPrevRow = getMinimumCost(mat, row - 1, col);
        int fromPreColumn = getMinimumCost(mat, row, col - 1);

        return Math.min(fromPrevRow, fromPreColumn) + mat[row][col];
    }

    public int getMinimumCost(int mat[][]) {
        int m = mat.length - 1;
        int n = mat[0].length - 1;

        return getMinimumCost(mat, m, n);
    }

    public int getMinimumCostTopDown(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;

        int dp[][] = new int[m][n];

        return getMinimumCost(dp, mat, m, n);
    }

    public int getMinimumCost(int dp[][], int mat[][], int row, int col) {

        if (row == -1 || col == -1) return Integer.MAX_VALUE;
        
        if (row == 0 && col == 0) return mat[0][0];
        
        if (dp[row][col] == 0) {

            int fromPrevRow = getMinimumCost(mat, row - 1, col);
            int fromPrevColumn = getMinimumCost(mat, row, col - 1);
            
            dp[row][col] = Math.min(fromPrevRow, fromPrevColumn) + mat[row][col];
        }
        
        return dp[row][col];
    }
    // Bottom up approach
    public int getMinimumCostTabulation(int mat[][]) {
        int row = mat.length;
        int col = mat[0].length;
        
        int dp[][] = new int[row + 1][col + 1]; // table from 1,1 -> row,col
        
        for(int i = 0; i <= row; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i <= col; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        
        dp[0][1] = 0; // for first comparision to give value
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + mat[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }
    
    public static void main(String[] args) {
        
    }
}
