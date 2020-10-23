package Notes.DFSsandBFS;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper529 {

    // 思路： 先检查周围有没有雷 如果有 当前格子只能填数字， 数字填多少取决于count 有多少个雷，
    // 如果周围没有雷 吧周围的点和当前点都变成B 周围的点加入queue中下次循环
    // BFS version

    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        // E -> 没点的 M -> 雷 B：点过的空白  数字： 点过后雷周围的数字
        int row = board.length;
        int column = board[0].length;
        if(board[click[0]][click[1]]  == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int count = 0;
            for(int[] dir : direction){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                if(x >=0 && x < row && y >= 0 && y < column){
                    if(board[x][y] == 'M'){
                        count++;
                    }
                }
            }
            if(count>0){
                board[cur[0]][cur[1]] = (char) (count+ '0');
            }
            else{
                board[cur[0]][cur[1]] = 'B';
                for(int[] dir : direction){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x >=0 && x < row && y >= 0 && y < column){
                        if(board[x][y] == 'E'){
                            queue.add(new int[] {x,y});
                            board[x][y] = 'B';
                        }
                    }
                }
            }
        }
        return board;
    }
}
