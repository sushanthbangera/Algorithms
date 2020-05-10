/*
 * Solution to https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
package algorithms;

/**
 *
 * @author Sushanth Bangera
 */
public class QueensAttackCounter {
    
    
    static int queensAttackOptimalSolution(int boardSize, int obstacleCount, int queen_x, int queen_y, int[][] obstacles) {
        int count;
        
        int south = queen_y - 1;
        int north = boardSize - queen_y;
        int west = queen_x - 1;
        int east = boardSize - queen_x;
        
        int south_west = Math.min(queen_x - 1, queen_y - 1);
        int north_west = Math.min(queen_x - 1, boardSize - queen_y);
        int north_east = Math.min(boardSize - queen_x, boardSize - queen_y);
        int south_east = Math.min(boardSize - queen_x, queen_y - 1);
        
        for (int i = 0; i < obstacleCount; i++) {
            
            int ox = obstacles[i][0];
            int oy = obstacles[i][1];
            
            // if x axis is same and queen is above the obstacle
            if (ox == queen_x && queen_y > oy) {
                south = Math.min(south,  queen_y - oy - 1);
            } 
            
             // if x axis is same and queen is below the obstacle
            if (ox == queen_x && queen_y < oy) {
                north = Math.min(north,  oy - queen_y - 1);
            }
            
            // if y axis is same and queen is right the obstacle
            if (oy == queen_y && queen_x > ox) {
                west = Math.min(west, queen_x - ox - 1);
            }
            
            // if y axis is same and queen is left the obstacle
            if (oy == queen_y && queen_x < ox) {
                east = Math.min(east, ox - queen_x - 1);
            }
            
            int oxDiff = queen_x - ox;
            int oyDiff = queen_y - oy;
            
            // if the absoulute difference of points are same, then obstacle is diagonally located
            if (Math.abs(oxDiff) == Math.abs(oyDiff)) {
                
                if (oxDiff > 0 && oyDiff > 0) {
                    south_west = Math.min(south_west, queen_x - ox - 1);
                }
                
                if (oxDiff > 0 && oyDiff < 0) {
                    north_west = Math.min(north_west, queen_x - ox - 1);
                }
                
                if (oxDiff < 0 && oyDiff < 0) {
                    north_east = Math.min(north_east, ox - queen_x - 1);
                }
                
                if (oxDiff < 0 && oyDiff > 0) {
                    south_east = Math.min(south_east, ox - queen_x - 1);
                }
                        
            }
        }
        count = south + west + north + east + south_west + north_west + north_east + south_east;
        return  count;
    }
    
    // Time consuming : since obstacle is iterated for every move of queen
    static int queensAttack(int boardSize, int obstacleCount, int queen_x, int queen_y, int[][] obstacles) {
    int count = 0;

        // diagonal south-west
        for (int i = queen_x - 1, j = queen_y - 1; i >= 1 && j >= 1; i--, j--) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }
        // diagonal north-west
        for (int i = queen_x - 1, j = queen_y + 1; i >= 1 && j <= boardSize; i--, j++) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }
        // diagonal north-east
        for (int i = queen_x + 1, j = queen_y + 1; i <= boardSize && j <= boardSize; i++, j++) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }
        // diagonal south-east
        for (int i = queen_x + 1, j = queen_y - 1; i <= boardSize && j >= 1; i++, j--) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }
        // south
        for (int i = queen_x, j = queen_y - 1; j >= 1; j--) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }
        // north
        for (int i = queen_x, j = queen_y + 1; j <= boardSize; j++) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }
        // east
        for (int i = queen_x - 1, j = queen_y; i >= 1; i--) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }
        // west
        for (int i = queen_x + 1, j = queen_y; i <= boardSize; i++) {
            if (isObstaclePresent(i, j, obstacles, obstacleCount)) {
                break;
            }
            count++;
        }

        return count;

    }

    private static boolean isObstaclePresent(int x, int y, int[][] obstacles, int k) {
        boolean isPresent = false;
        for (int i = 0; i < k; i++) {
            if (obstacles[i][0] == x && obstacles[i][1] == y) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }
    
}
