package DynamicProgramming;

public class longestCross {

    //Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.
    //
    //Return the arm length of the largest cross.
    //
    //Assumptions
    //
    //The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
    //Examples
    //
    //{ {0, 0, 0, 0},
    //
    //  {1, 1, 1, 1},                               1
    //
    //  {0, 1, 1, 1},                            1  1  1
    //
    //  {1, 0, 1, 1} }                              1
    //
    //the largest cross of 1s has arm length 2.


    public int longest(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] leftUp = leftUp(matrix, M, N);
        int[][] rightDown = rightDown(matrix, M, N);
        return merge(leftUp, rightDown, M, N);
    }
    private int[][] leftUp(int[][] matrix, int M, int N){
        int[][] left = new int[M][N];
        int[][] up = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 && j == 0){
                        up[i][j] = 1;
                        left[i][j] = 1;
                    } else if(i == 0){
                        up[i][j] = 1;
                        left[i][j] = left[i][j-1]+1;
                    } else if(j == 0){
                        left[i][j] = 1;
                        up[i][j] = up[i-1][j]+1;
                    } else {
                        up[i][j] = up[i-1][j] + 1;
                        left[i][j] = left[i][j-1] + 1;
                    }
                }
            }
        }
        merge(left, up, M, N);
        return left;
    }
    private int[][] rightDown(int[][] matrix, int M, int N){
        int[][] right = new int[M][N];
        int[][] down = new int[M][N];
        for(int i = M - 1; i >= 0; i--){
            for(int j = N - 1; j >= 0; j--){
                if(matrix[i][j] == 1){
                    if(i == N - 1 && j == M - 1){
                        right[i][j] = 1;
                        down[i][j] = 1;
                    } else if(i == N - 1){
                        down[i][j] = 1;
                        right[i][j] = right[i][j+1] + 1;
                    } else if(i == M - 1){
                        down[i][j] = down[i+1][j] + 1;
                        right[i][j] = 1;
                    } else {
                        down[i][j] = down[i+1][j] + 1;
                        right[i][j] = right[i][j+1] + 1;
                    }
                }
            }
        }
        merge(right, down, M, N);
        return right;
    }
    private int merge(int[][] leftUp, int[][] rightDown, int M, int N){
        int result = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(leftUp[i][j], result);
            }
        }
        return result;
    }





    public int longestCross(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int column = matrix.length;
        int row = matrix[0].length;
        int[][] dp = new int[column+1][row+1];
        int count;
        int max = 0;
        // left right;
        for(int  i = 0; i >column ; i--){
            count = 0;
            for(int j = 0; j > row; j--){

                if(matrix[i][j] == 1){
                    count++;
                }
                else{
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);


            }
        }
        // right left

        for(int  i = column; i > 0; i--){
            count = 0;
            for(int j = row; j > 0; j--){

                if(matrix[i][j] == 1){
                    count++;
                }
                else{
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);


            }
        }
        //top down
        for(int  i = 0; i >row ; i--){
            count = 0;
            for(int j = 0; j > column; j--){

                if(matrix[i][j] == 1){
                    count++;
                }
                else{
                    count = 0;
                }
                dp[i][j] = Math.min(dp[i][j], count);


            }
        }
        // bottom up
        for(int  i = row; i >0 ; i--){
            count = 0;
            for(int j = column; j > 0; j--){

                if(matrix[i][j] == 1){
                    count++;
            }
                else{

                    count =0;
                }
                dp[i][j] = Math.min(dp[i][j], count);
                max =Math.max(dp[i][j], max);

            }
        }

        return max;



    }


}
