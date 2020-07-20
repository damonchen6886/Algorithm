package _6BFSwithHeap.day17;

import java.util.PriorityQueue;

public class KthSmallestMatrix {
    //Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
    //
    //Assumptions
    //
    //               resultlst (1 2,3,3)  3 2
    //
    //the matrix is not null, N > 0 and M > 0
    //K > 0 and K <= N * M
    //Examples
    //
    //count = 2
    //heap [,3,4,5]
    // {{1,  3,   5,  7},
    //
    //  {2,  4,   8,  9},
    //
    //  {3,  5, 11,  15},
    //
    //  {6,  8, 13,  18}}
    //
    //the 5th smallest number is 4
    //the 8th smallest number is 6


    // DFS, BFS1(Breath First Search), BFS2(Best First Search)

    // BFS1:
    //    marker, queue

    // BFS2:
    //    marker, priorityqueue

    // Binary Search(for its value)
    public int kthSmallest0(int[][] matrix, int k){
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m][n];
        while(left < right){
            int mid = left + (right - left)/2;
            int count = 0, j = m-1;
            for(int i = 0; i < m; i++){
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j+1);
            }
            if(count < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // bfs2 通常而言是有按一定规律进行方向的搜索的，通常只有两个方向。
    public  int kthsmallest2(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;

        }
        int[][] direction = {{1,0},{0,-1}};
        int column = matrix.length ;
        int row = matrix[0].length;
        boolean[][] visited = new boolean[column][row];

        PriorityQueue<Point> heap = new PriorityQueue<>((p1, p2) -> {
            if(p1.value == p2.value){
                return 0;
            }
            return p1.value < p2.value ? -1:1;
        });
        heap.offer(new Point(0,0,matrix[0][0]));
        visited[0][0] = false;
        for(int j = 0; j < k-1; j++){
            Point p = heap.poll();
            for(int i = 0; i< direction.length; i++){
                int x = p.x+ direction[i][0];
                int y = p.y+ direction[i][1];
                if(x > 0 && x < column && y > 0 && y< row && !visited[x][y]){
                    heap.offer(new Point(x,y,matrix[x][y]));
                    visited[x][y] = true;
                }
            }

        }
        Point result= heap.peek();
        return result.value;
    }

    public int kthSmallest(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0].length  == 0 || k < 0){
            return -1;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // int byte boolean long short char -> Integer, Boolean, Long, Char

        PriorityQueue<Point> minHeap = new PriorityQueue<Point>(k, (c1, c2) -> {

            if(c1.value == c2.value){
                return 0;
            }
            return c1.value < c2.value ? -1:1;
        });
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new Point(0,0,matrix[0][0]));
        visited[0][0] = true;
        for(int i = 0; i < k - 1; i++){
            Point cur = minHeap.poll();
            if(cur.x + 1 < rows && !visited[cur.x + 1][cur.y]){
                minHeap.offer(new Point(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited[cur.x+1][cur.y] = true;
            }
            if(cur.y + 1 < cols && !visited[cur.x][cur.y + 1]){
                minHeap.offer(new Point(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y+1] = true;
            }

        }
        return minHeap.peek().value;
    }



//     while(!queue.isEmpty())
//     1 2 3 4 5
//     3 4 5 6 7
//     4 5 6 7 8
//     used              [1,2,3,3,4, 4,4,5,5]
//     priority queue    [,4,4,5,5]



    class Point{
        int x, y,value;
        Point(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,3,5,7},{2,4,8,9},{3,6,11,15},{6,8,13,18}};
        KthSmallestMatrix k1 = new KthSmallestMatrix();
//        System.out.println("expected 5th = 4, actual =  " + k1.kthsmallest2(matrix1,5));
//        System.out.println("expected 8th = 6, actual =  " + k1.kthsmallest2(matrix1,8));
        System.out.println("expected 5th = 4, actual =  " + k1.kthSmallest(matrix1,5));
        System.out.println("expected 8th = 6, actual =  " + k1.kthSmallest(matrix1,8));
//        System.out.println("expected 5th = 4, actual =  " + k1.kthsmallest2(matrix1,5));
//        System.out.println("expected 8th = 6, actual =  " + k1.kthsmallest2(matrix1,8));
//        System.out.println("expected 5th = 4, actual =  " + k1.kthSmallest0(matrix1,5));
//        System.out.println("expected 8th = 6, actual =  " + k1.kthSmallest0(matrix1,8));
    }



}
