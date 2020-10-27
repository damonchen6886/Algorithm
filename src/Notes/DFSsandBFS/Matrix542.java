package Notes.DFSsandBFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix542 {

    class Solution {
        //思路： 吧所有的0全放进queue里 每一圈遍历 distance ++ 得到的就是正确答案 相似问题： LC994
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null || matrix.length ==0){
                return matrix;
            }
            int row = matrix.length;
            int column = matrix[0].length;
            int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[row][column];
            for(int i =0; i < row;i++){
                for(int  j =0; j < column;j++){
                    if(matrix[i][j] == 0){
                        queue.offer(new int[]{i,j});
                    }
                    else{
                        matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            int dis = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                dis++;
                for(int i =0; i < size;i++){
                    int[] cur = queue.poll();
                    for(int[] dir: direction){
                        int x = cur[0]+ dir[0];
                        int y = cur[1] + dir[1];

                        if(x>= 0 && x< row && y>=0 && y < column){
                            if(matrix[x][y] == Integer.MAX_VALUE){
                                matrix[x][y] = dis;
                                queue.offer(new int[]{x,y});
                            }
                        }
                    }
                }
            }
            return matrix;
        }
    }
}
