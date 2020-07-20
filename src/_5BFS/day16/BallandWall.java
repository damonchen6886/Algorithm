package _5BFS.day16;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BallandWall {

    // There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
// Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
// The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.


// Example 1:
// Input 1: a maze represented by a 2D array

// 0 0 1 0 0
// 0 0 0 0 0
// 0 0 0 1 0
// 1 1 0 1 1
// 0 0 0 0 0

// Input 2: start coordinate (rowStart, colStart) = (0, 4)
// Input 3: destination coordinate (rowDest, colDest) = (4, 4)

// Output: true

// Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
// Example 2:
// Input 1: a maze represented by a 2D array

// 0 0 1 0 0
// 0 0 0 0 0
// 0 0 0 1 0
// 1 1 0 1 1
// 0 0 0 0 0

// Input 2: start coordinate (rowStart, colStart) = (0, 4)
// Input 3: destination coordinate (rowDest, colDest) = (3, 2)

// Output: false

// Explanation: There is no way for the ball to stop at the destination.

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1},{0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] end){
        if(maze == null || maze.length == 0 || maze[0].length == 0 || start == null || end == null || start.length != 2 || end.length != 2) return false;
        int m = maze.length;
        int n = maze[0].length;
        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(start);
        boolean[][] visited = new boolean[m][n];
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(pos[0] == end[0] && pos[1] == end[1]){
                return true;
            }
            for(int[] dir : dirs){
                int nextX = pos[0];
                int nextY = pos[1];
                while(canRoll1(maze, nextX + dir[0], nextY + dir[1])){
                    nextX += dir[0] ;
                    nextY += dir[1];
                }
                if(!visited[nextX][nextY]){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }
    private boolean canRoll1(int[][] maze, int nextX, int nextY){
        int m = maze.length;
        int n = maze[0].length;
        return nextX < m && nextX >= 0 && nextY < n && nextY >= 0 && maze[nextX][nextY] == 0;
    }



    //DFS approach:

    public boolean hasPathdfs(int[][] maze, int[] start, int[] end){
        // sanity check
        if(maze == null || maze.length == 0 || maze[0].length == 0 || start == null || end == null || start.length != 2 || end.length != 2) return false;
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, end, visited);
    }
    private boolean dfs(int[][] maze, int[] start, int[] end, boolean[][] visited){
        // base case: if it has been traversed before
        if(visited[start[0]][start[1]]){
            return false;
        }
        // base case2: if the answer has been found
        if(Arrays.equals(start, end)){
            return true;
        }
        // recursion rule:
        // step 1: record the marker
        visited[start[0]][start[1]] = true;
        for(int i = 0; i < dirs.length; i++){
            int[] newPosition = roll(maze, start, dirs[i]);

            if(dfs(maze, newPosition, end, visited)){
                return true;
            }
        }
        visited[start[0]][start[1]] = false;
        return false;
    }
    private int[] roll(int[][] maze, int[] start, int[] dir){
        int row = start[0];
        int col = start[1];
        while(canRoll2(maze, row + dir[0], col + dir[1])){
            row += dir[0];
            col += dir[1];
        }
        return new int[]{row, col};
    }
    private boolean canRoll2(int[][] maze, int nextRow, int nextCol){
        int m = maze.length;
        int n = maze[0].length;
        if(nextRow < 0 || nextRow > m || nextCol < 0 || nextCol >= n){
            return false;
        }
        if(maze[nextRow][nextCol]==1){
            return false;
        }
        return true;
    }


}
