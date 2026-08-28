// Last updated: 8/28/2026, 8:51:06 AM
/*
 * Intuition is similar to 2d range sum query, Twist is that for square id checking i, j in prefix matrix (nrows + 1, ncols + 1) top left, top, and left elements (min of them would signify the side of max square with i, j in it. 
 * 
 * time complexity: O(n^2)
 * space complexity: O(n^2)
*/

1class Solution {
2    public int maximalSquare(char[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int[][] temp = new int[m + 1][ n + 1];
6        int maxSqrSide = 0;
7        for(int i = 1; i <= m; i++) {
8            for(int j = 1; j <= n; j++) {
9                if(matrix[i-1][j-1] == '1') {
10                    // Take min of top left, top and left so that if all of them are 1 then square is of size 2
11                    temp[i][j] = Math.min(Math.min(temp[i-1][j-1], temp[i][j-1]), temp[i-1][j]) + 1;
12                    maxSqrSide = Math.max(temp[i][j], maxSqrSide);
13                }
14            }
15        }
16        return maxSqrSide * maxSqrSide;
17    }
18}