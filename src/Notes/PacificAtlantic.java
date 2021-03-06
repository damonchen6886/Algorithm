package Notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {

    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visitedp = new boolean[m][n];
        boolean[][] visiteda = new boolean[m][n];
        for(int i = 0; i< m;i++){
            dfs(matrix, visitedp,Integer.MIN_VALUE,i,0);
            dfs(matrix, visiteda,Integer.MIN_VALUE,i, n-1);
        }
        for(int i = 0; i < n;i++){
            dfs(matrix, visitedp,Integer.MIN_VALUE,0,i);
            dfs(matrix, visiteda,Integer.MIN_VALUE,m-1,i);
        }
        for(int i = 0;  i< m;i++){
            System.out.println(Arrays.toString(visiteda[i]));
        }
        System.out.println("*******");
        for(int i = 0;  i< m;i++){
            System.out.println(Arrays.toString(visitedp[i]));
        }
        for(int i = 0; i< m;i++){
            for(int j = 0; j < n;j++){
                if(visitedp[i][j] && visiteda[i][j]){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    result.add(arr);
                }
            }
        }
        return result;
    }


    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y){

        visited[x][y] = true;
        for(int[] dir: directions){
            int a = x+dir[0];
            int b = y+dir[1];
            if(a >= 0 && a < matrix.length && b >= 0 && b < matrix[0].length && !visited[a][b] && matrix[a][b] >= matrix[x][y]){
                // visited[a][b] = true;
                dfs(matrix, visited, matrix[x][y], a, b);
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        PacificAtlantic p = new PacificAtlantic();
        System.out.println(p.pacificAtlantic(test));
    }

}
