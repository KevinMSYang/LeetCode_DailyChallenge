//Question:59
//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
//
//
//Example 1:
//
//
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
//Example 2:
//
//Input: n = 1
//Output: [[1]]

package Array;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0;
        int c = 0;
        int dir = 0;
        int num = 1;
        for (int i = 0; i < n * n; i++) {
            arr[r][c] = num++;
            seen[r][c] = true;

            int nextR = r + directions[dir][0];
            int nextC = c + directions[dir][1];
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || seen[nextR][nextC]) {
                dir = (dir + 1) % 4;
                nextR = r + directions[dir][0];
                nextC = c + directions[dir][1];
            }
            r = nextR;
            c = nextC;
        }
        return arr;
    }
}
