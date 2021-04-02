package DynamicProgramming;

public class LonestIncreasingContinueSubsqunce2D {

    //O(nm) time and memory.
    //
    //Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
    //Example
    //Given a matrix:
    //[
    // [1 ,2 ,3 ,4 ,5],
    // [16,17,24,23,6],
    // [15,18,25,22,7],
    // [14,19,20,21,8],
    // [13,12,11,10,9]
    //]
    //return 25

    // dfs with dp memorization
    int[][] dp;
    int[][] visited;
    int N, M;

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    public int longest(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        M  = matrix.length;
        N = matrix[0].length;
        dp = new int[M][N];
        visited = new int[M][N];
        int result = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                dp[i][j] = search(i, j, matrix);  // dp[i][j] = represent the longest length starting form matrix[i][j]
                result = Math.max(result, dp[i][j]);
            }
        }
        return result+1;
    }
    // Memorization
    public int search(int x, int y, int[][] matrix){
        if(visited[x][y] != 0){
            return dp[x][y];
        }
        int result = 0;
        int nextX, nextY;
        visited[x][y] = 1;
        for(int i = 0; i < dx.length; i++){
            nextX = x + dx[i];
            nextY = y + dy[i];
            if(valid(nextX, nextY) && matrix[x][y] > matrix[nextX][nextY]){
                result = Math.max(result, search(nextX, nextY, matrix) + 1);
            }
        }
        dp[x][y] = result;
        return result;
    }
    private boolean valid(int x, int y){
        return x >= 0 && y >= 0 && x < M && y < N;
    }




    // Pure DFS:
    public int lcsMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int result = 0;
        boolean[][] visited  = new boolean[row][column];
        int cur = 0;
        for(int i =0; i < row; i++){
            for(int j = 0; j < column; j++){
                visited  = new boolean[row][column];
                cur = dfs(matrix,i, j,  visited);
                result = Math.max(result, cur);
            }
        }
        return result+1;

    }
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

    private int dfs(int[][] matrix, int row, int col, boolean[][] visited){
        if(row < 0 || row > matrix.length || col < 0 || col > matrix[0].length || visited[row][col]){
            return 0;
        }
        visited[row][col] = true;
        int right = 0, left = 0, down= 0, up= 0;
        if(row != matrix.length-1 && matrix[row+1][col] > matrix[row][col]){
             right = dfs(matrix, row+1, col,  visited) + 1;
        }
        if(row != 0 && matrix[row-1][col] > matrix[row][col]){
             left = dfs(matrix, row -1, col,  visited) + 1;
        }
        if(col != matrix[0].length && matrix[row][col+1] > matrix[row][col]){
             down = dfs(matrix, row, col + 1,  visited) + 1;
        }
        if(col != 0 && matrix[row][col-1] > matrix[row][col]){
             up = dfs(matrix, row, col - 1,  visited) + 1;
        }
        visited[row][col] = false;
        return Math.max(right, Math.max(left, Math.max(up, down)));
    }
}
