/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.matrices;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sushanth Bangera
 */
public class SpiralMatrix {

    public List<Integer> spiralMatrix(int[][] matrix, int direction) {
        List<Integer> nums = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return nums;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;

        while (nums.size() < size) {
            if (direction == 1) { // clockwise
                
                leftToRight(left, right, nums, matrix, size, top);
                top++;

                topToBottom(top, bottom, nums, matrix, size, right);
                right--;

                rightToLeft(right, left, nums, matrix, size, bottom);
                bottom--;

                bottomToTop(bottom, top, nums, matrix, size, left);
                left++;
            } else {
                rightToLeft(right, left, nums, matrix, size, top);
                top++;

                topToBottom(top, bottom, nums, matrix, size, left);
                left++;

                leftToRight(left, right, nums, matrix, size, bottom);
                bottom--;

                bottomToTop(bottom, top, nums, matrix, size, right);
                right--;
            }
        }
        return nums;
    }

    private void leftToRight(int left, int right, List<Integer> nums, int[][] matrix, int size, int row) {
        for (int i = left; i <= right && nums.size() < size; i++) {
            nums.add(matrix[row][i]);
        }
    }

    private void rightToLeft(int right, int left, List<Integer> nums, int[][] matrix, int size, int row) {
        for (int i = right; i >= left && nums.size() < size; i--) {
            nums.add(matrix[row][i]);
        }
    }

    private void topToBottom(int top, int bottom, List<Integer> nums, int[][] matrix, int size, int column) {
        for (int i = top; i <= bottom && nums.size() < size; i++) {
            nums.add(matrix[i][column]);
        }
    }

    private void bottomToTop(int bottom, int top, List<Integer> nums, int[][] matrix, int size, int column) {
        for (int i = bottom; i >= top && nums.size() < size; i--) {
            nums.add(matrix[i][column]);
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int temp[][] = mat;
       
        temp = mat;
        List<Integer> spiralMatNums = new SpiralMatrix().spiralMatrix(temp, 1);
        utils.Utility.printArray(spiralMatNums.toArray());
        
        temp = mat;
        spiralMatNums = new SpiralMatrix().spiralMatrix(temp, 2);
        utils.Utility.printArray(spiralMatNums.toArray());

        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        temp = matrix;
        spiralMatNums = new SpiralMatrix().spiralMatrix(temp, 1);
        utils.Utility.printArray(spiralMatNums.toArray());
        
        spiralMatNums = new SpiralMatrix().spiralMatrix(matrix, 2);
        utils.Utility.printArray(spiralMatNums.toArray());

    }
}
