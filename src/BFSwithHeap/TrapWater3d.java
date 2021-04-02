package _6BFSwithHeap.day18;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapWater3d {

    //Question
    //Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, compute how much water it is able to trap after raining.
    //
    //Given 5*4 matrix
    //
    //
    //[[12,13,0,12]
    //[13,4,13,12]
    //[13,8,10,12]
    //[12,13,12,12]
    //[13,13,13,13]]

    public int trapwater3d(int[][] arr){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return 0;
        }
        int row =arr.length;
        int column = arr[0].length;
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[row][column];
        PriorityQueue<Point> queue=  new PriorityQueue<>(arr.length, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.value == p2.value){
                    return 0;
                }
                return p1.value > p2.value ? 1:-1;
            }
        });
        for(int i = 0;  i < row; i++){
            for(int j = 0; j < column; j++){
                if(i == 0 || i == row-1 || j ==0 || j == column-1){
                    queue.offer(new Point(i,j, arr[i][j]));
                }
            }

        }
        int result = 0;
        while(!queue.isEmpty()){
            for(int i = 0; i < direction.length; i++){
                Point p = queue.poll();
                int x  = p.x + direction[i][0];
                int y = p.y + direction[i][1];
                if(x >= 0 && x< row && y>= 0  && y < column && !visited[x][y]){
                    visited[x][y] = true;
                    result += Math.max(0, p.value - arr[x][y]);
                    queue.offer(new Point(x,y, Math.max(arr[x][y], p.value)));

                }
            }
        }

        return result;
    }





    class Point{
        int x;
        int y;
        int value;
        public Point(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

    }
}
