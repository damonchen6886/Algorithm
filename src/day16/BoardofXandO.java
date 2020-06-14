package day16;

import java.util.Deque;
import java.util.LinkedList;

public class BoardofXandO {

    //Question
    //Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
    //A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
    //Example
    //X X X X
    //X O O X
    //X X O X
    //X O X X
    //After capture all regions surrounded by 'X', the board should be:
    //X X X X
    //X X X X
    //X X X X
    //X O X X


    public void reverse(String[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return;
        }
        int column = map.length;
        int line = map[0].length;
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Deque<Point> queue = new LinkedList<>();

        for(int i = 0; i < line; i++){
            for(int j = 0; j < column; j++){
                if(i == 0 || i == column-1 || j ==0 || j == line-1){
                    if(map[i][j].equals("O")){
                        queue.offer(new Point(i,j));

                        while(!queue.isEmpty()){
                            Point p = queue.poll();

                            for(int k = 0; k < direction.length; k++){
                                int x = p.x+direction[k][0];
                                int y = p.x+direction[k][1];
                                if(x >=0 && x < line-1 && y>= 0&& y<column-1 && map[x][y].equals("O")){
                                    queue.offer(new Point(x,y));
                                    map[x][y] = "#";
                                }
                            }

                        }

                    }
                }

            }

        }
        for(int i = 0 ; i < line; i++){
            for(int j =0; j < column; j++){
                if(map[i][j] == "O"){
                    map[i][j] = "X";
                }
                else if(map[i][j] == "#"){
                    map[i][j] ="O";
                }

            }
        }


    }



    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}



