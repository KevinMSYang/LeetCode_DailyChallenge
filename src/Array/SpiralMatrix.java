//Question:54
//Given an m x n matrix, return all elements of the matrix in spiral order.
//
//		 
//
//Example 1:
//
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//
//
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]

package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> list = new ArrayList<>();
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];

        int r = 0;
        int c = 0;
        int dir = 0;

        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            list.add(matrix[r][c]);
            seen[r][c] = true;

            int nextR = r + directions[dir][0];
            int nextC = c + directions[dir][1];

            if (nextR < 0 || nextR >= matrix.length || nextC < 0 || nextC >= matrix[0].length || seen[nextR][nextC]) {
                dir = (dir + 1) % 4;
                nextR = r + directions[dir][0];
                nextC = c + directions[dir][1];
            }

            r = nextR;
            c = nextC;
        }
        return list;
    }
}
