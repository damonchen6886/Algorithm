package DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class LargestSqure {
    //Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
    //
    //Assumptions
    //
    //The given matrix is not null and guaranteed to be of size N * N, N >= 0
    //Examples
    //
    //{ {0, 0, 0, 0},
    //
    //  {1, 1, 1, 1},
    //
    //  {0, 1, 1, 1},
    //
    //  {1, 0, 1, 1}}
    //
    //the largest square of 1s has length of 2

    //DP solution:
    public int largest(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int globalMax = 0;
        int[][] dp = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    // base case;
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, dp[i-1][j] + 1);
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, dp[i][j]);
                }

                globalMax = Math.max(globalMax, dp[i][j]);
            }

        }
        return globalMax*globalMax;
    }

    // better space vsersion:
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] dp = new int[column+1];

        int prev = 0;
        int result = 0;
        for(int i = 1; i< row+1; i++){
            for(int j = 1; j < column+1; j++){
                int temp = dp[j];

                if(matrix[i-1][j-1] =='1'){

                    dp[j] = Math.min(dp[j-1] ,Math.min(dp[j],prev))+1;
                    result = Math.max(result, dp[j]);

                }
                else{dp[j] =0;}

                prev = temp;
            }


        }
        return result*result;


    }


    // BFS solution:
    public int LargestSquare(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int column = matrix.length;
        int row = matrix[0].length;
        boolean[][] visited = new boolean[column][row];
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < column; i++){
            for(int j = 0; j < row; j++){
                queue.offer(new Point(i, j, matrix[i][j]));

            }
        }
        int result = 0;
        int count =0;
        boolean flag = false;
        int[][] direction =  {{1,0},{0,-1}, {1,1}};
        for (int[] ints : matrix) {
            for (int b = 0; b < row; b++) {
                if (ints[b] == 1) {
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            Point p = queue.poll();
                            for (int[] dir : direction) {
                                int x = p.x + dir[0];
                                int y = p.y + dir[1];
                                if (x > 0 && x < column && y > 0 && y < row && !visited[x][y]) {
                                    if (matrix[x][y] == 0) {
                                        flag = false;
                                        break;


                                    } else {
                                        flag = true;
                                        queue.offer(new Point(x, y, matrix[x][y]));
                                        visited[x][y] = true;
                                        //                         count++;
                                    }
                                }
                            }
                        }

                        if (flag) {
                            count++;
                        }

                    }


                }
            }
            result = Math.max(result, count);
            count =0;


        }
        return result;


    }
        static class Point{
            int x;
            int y;
            int val;
            public Point(int x, int y, int val){
                this.x = x;
                this.y = y;
                this.val =val;
            }
        }


    }



