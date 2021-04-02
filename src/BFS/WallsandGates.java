package BFS;

import java.util.Deque;
import java.util.LinkedList;

public class WallsandGates {

    // dfs(recursion)
    // core questions:
    //     1 : how many states in each level
    //     2 : how many level do we need
    // code block:
    //     1 : base case (return)
    //          1.1 record the current level
    //          1.2 通过边界条件来确定返回状况
    //     2: recursion rule
    //         1.1 : 有几个递归体，就有几个分叉(states)
    //             : 当递归条件比较规律且数量较少，可以使用并排写递归体
    //             : 否则使用for loop
    //         1.2 : 当有返回值的时候
    //             T value1 = dfs(xxx.left);
    //             T value2 = dfs(xxx.right);
    //             return 一种算法的计算结果
    //    templates of dfs
    //         1: if (base case) return xxx;
    //         2: recursion rule
    //         3: return xxx;

    // bfs :
    //    1: core question:
    //      we can only generate from a node once
    //    2: what we need?
    //        1.queue
    //        2: record the size of current level or we will use a marker
    // bfs method



//
//You are given a m x n 2D grid initialized with these three possible values.
//        -1- A wall or an obstacle.
//        0- A gate.
//        INF- Infinity means an empty room. We use the value 2^31- 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//        Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//        Example:
//        Given the 2D grid:
//        INF  -1  0  INF
//        INF INF INF  -1
//        INF  -1 INF  -1
//        0  -1 INF INF
//
//
//
//
//        After running your function, the 2D grid should be:
//        3  -1   0   1
//        2   2   1  -1
//        1  -1   2  -1
//        0  -1   3   4
//
//
//        }


    public void wallsAndGates(int[][] rooms){
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int EMPTY = Integer.MAX_VALUE;
        int GATE = 0;
        int WALL = -1;
        // flooding directions (required)
        int[][] directions = new int[][]{
                {-1,0},{0,1},{1,0},{-1,0}
        };
        Deque<Point> queue = new LinkedList<Point>();
        int m = rooms.length;
        int n = rooms[0].length;
        // find the entrance

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == GATE){
                    queue.offer(new Point(i,j));
            }
        }
    }
    // start the flooding (required);
        while(!queue.isEmpty()){
        Point p = queue.poll();
        for(int i = 0; i < directions.length; i++){
            int x = p.x + directions[i][0];
            int y = p.y + directions[i][1];
            if( x < 0 || x > m - 1 || y < 0 || y > n - 1 || rooms[x][y] != EMPTY){
                continue;
            }
            rooms[x][y] = rooms[p.x][p.y] + 1;
            queue.offer(new Point(x, y));
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




    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

}
