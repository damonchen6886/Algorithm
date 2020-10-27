package Notes.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//思路： 先给stack里面无脑加 直到碰到']' 的时候开始pop 吧所有pop的东西存到一个list里面， 等pop到'['的时候 停止pop， 在pop一次，
// 把'[' 给pop掉 然后 处理前面的数字， 吧得到的数字存起来，再把 数字* list 里面的东西 全部加到stack里面 继续循环， 直到把所有的char都遍历完。
// 然后stack里面存的就是答案了， 在吧stack的东西 放到result就就是答案
public class DecodeString394 {
    public String decodeString(String s) {
        if(s.length() ==0){
            return s;
        }
        StringBuilder result = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                dq.push(s.charAt(i));
            }
            else if(s.charAt(i) == ']'){
                List<Character> cur = new ArrayList<>();
                while(dq.peek() != '['){
                    char c = dq.pop();
                    cur.add(c);
                }
                dq.pop();
                int base = 1;
                int times = 0;
                while(!dq.isEmpty() && Character.isDigit(dq.peek())){
                    times+=(dq.pop() -'0')*base;
                    base*=10;
                }
                for(int j = 0; j < times; j++){
                    for(int k  =cur.size()-1; k >= 0; k--){
                        dq.push(cur.get(k));
                    }
                }
            }
        }
        while(!dq.isEmpty()){
            result.insert(0, dq.pop());
        }
        return result.toString();
    }



    //dfs version:
    public String decodeString2(String s) {
        Deque<Character> dq= new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            dq.offer(c);
        }
        return dfs(dq);

    }

    private String dfs(Deque<Character> dq){
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(!dq.isEmpty()){
            char c = dq.pop();
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }else if(c == '['){
                String s = dfs(dq);
                for(int i =0; i <num; i++){
                    sb.append(s);
                }
                num =0;
            }
            else if(c == ']'){
                break;
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

//    public int minimumEffortPath(int[][] matrix) {
//        if(matrix == null || matrix.length ==0){
//            return 0;
//        }
//        int row  = matrix.length;
//        int column = matrix[0].length;
//        int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
//        boolean[][] visited = new boolean[row][column];
//        Queue<int[]> queue =new LinkedList<>();
//        queue.offer(new int[]{0,0});
//        int max =0;
//        int curMax =0;
//        while(!queue.isEmpty()){
//            int[] cur = queue.poll();
//            for(int[] dir: direction){
//                int x = cur[0]+ dir[0];
//                int y =cur[1] + dir[1];
//
//                if(x >= 0 && x < row && y >= 0  && y < row && !visited[x][y]){
//                    curMax = Math.min(curMax, matrix[x][y]);
//                    queue.offer(new int[]{x,y});
//                    visited[x][y] = false;
//                }
//            }
//            max = Math.max(max,curMax);
//        }
//        return max;
//        int a = Integer.MAX_VALUE
//    }

//        int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
//    public int minimumEffortPath(int[][] matrix) {
//        if(matrix == null || matrix.length ==0){
//            return 0;
//        }
//        int row  = matrix.length;
//        int column = matrix[0].length;
//        boolean[][] visited = new boolean[row][column];
//        int[] curMax = new int[]{0};
//        int[] max = new int[]{0};
//        dfs(matrix,max, curMax, 0,0,row,column, visited);
//        return max[0];
//    }
//    private void dfs(int[][] matrix, int[] curMax, int[] max, int x, int y, int row, int column, boolean[][] visited){
//        if(x >= 0 && x < row && y >= 0  && y < row && !visited[x][y]){
//            curMax[0] = Math.min(curMax[0], matrix[x][y]);
//            max[0] = Math.max(max[0], curMax[0]);
//        }
//        else{
//            return;
//        }
//        visited[x][y] = true;
//        for(int[] dir: direction){
//            dfs(matrix, curMax,max,x+dir[0], y+dir[1],row, column, visited);
//        }
//    }
//
    //------------------------------------------------
    //     public int minimumEffortPath(int[][] matrix) {
    //        if(matrix == null || matrix.length ==0){
    //            return 0;
    //        }
    //        int row  = matrix.length;
    //        int column = matrix[0].length;
    //        int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    //        boolean[][] visited = new boolean[row][column];
    //        boolean[][] isPut = new boolean[row][column];
    //        Queue<int[]> queue =new LinkedList<>();
    //        queue.offer(new int[]{0,0});
    //        isPut[0][0] = true;
    //        int max = 0;
    //        // int curMin =0;
    //        while(!queue.isEmpty()){
    //            int[] cur = queue.poll();
    //            visited[cur[0]][cur[1]] = true;
    //            // System.out.println("cur:: x = " +cur[0]  + "y = " + cur[1]);
    //            if(cur[0] == row-1 && cur[1] == column-1){
    //                break;
    //            }
    //            int curMin = Integer.MAX_VALUE;
    //            for(int[] dir: direction){
    //                int x = cur[0]+ dir[0];
    //                int y =cur[1] + dir[1];
    //                // System.out.println("cur:: x = " +cur[0]  + "y = " + cur[1]);
    //                // System.out.println("x = "+ x +  "y = " +y);
    //                if(x >= 0 && x < row && y >= 0  && y < column && !visited[x][y]){
    //                    int dif = Math.abs(matrix[x][y]- matrix[cur[0]][cur[1]]);
    //                    // System.out.println("matrix[x][y] = " + x + " " + y);
    //                    // System.out.println("dif is = " +dif );
    //                    curMin = Math.min(curMin, dif);
    //                    // System.out.println("curMIN = "+curMin);
    //                    if(!isPut[x][y]){
    //                        isPut[x][y] = true;
    //                        queue.offer(new int[]{x,y});
    //                    }
    //
    //                }
    //
    //            }
    //
    //            max = Math.max(max,curMin);
    //        }
    //        return max;
    //    }

    //class Solution {
    //    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    //    public int minimumEffortPath(int[][] heights) {
    //        if(heights == null || heights.length == 0 || heights[0].length == 0){
    //            return 0;
    //        }
    //        int m = heights.length, n = heights[0].length;
    //        int[] min = new int[]{Integer.MAX_VALUE};
    //        int[] max = new int[]{Integer.MIN_VALUE};
    //        boolean[][] visited = new boolean[m][n];
    //        dfs(heights, visited, 0, 0, min, max);
    //        return min[0] < 0 ? 0 : min[0];
    //    }
    //    private void dfs(int[][] heights, boolean[][] visited, int m, int n, int[] min, int[] max){
    //        if(m == heights.length - 1 && n == heights[0].length - 1){
    //            min[0] = Math.min(max[0], min[0]);
    //            return;
    //        }
    //
    //        visited[m][n] = true;
    //        for(int[] dir : dirs){
    //            int x = m + dir[0];
    //            int y = n + dir[1];
    //            if(x >= 0 && y >= 0 && x < heights.length && y < heights[0].length && !visited[x][y]){
    //                int temp = max[0];
    //                max[0] = Math.max(max[0], Math.abs(heights[m][n] - heights[x][y]));
    //                dfs(heights, visited, x, y, min, max);
    //                max[0] = temp; // return to origin when backtracking
    //            }
    //        }
    //        visited[m][n] = false;
    //    }
    //}

    //----
    //       int[][] direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    //   public int minimumEffortPath(int[][] matrix) {
    //       if(matrix == null || matrix.length ==0){
    //           return 0;
    //       }
    //       int row  = matrix.length;
    //       int column = matrix[0].length;
    //       boolean[][] visited = new boolean[row][column];
    //       int[] min = new int[]{Integer.MAX_VALUE};
    //       int[] curMax = new int[]{Integer.MIN_VALUE};
    //       dfs(matrix, min, 0,0,row,column, visited, curMax);
    //       return min[0];
    //   }
    //   private int dfs(int[][] matrix, int[] min, int x, int y, int row, int column, boolean[][] visited, int[] curMax){
    //       // base case 1: invalid pruning
    //       if(x >= row || x < 0 || y >= column || y < 0 || visited[x][y]){
    //           return 0;
    //       }
    //       // base case 2: return useful value
    //       if(x == row-1 && y == column-1){
    //           min[0] = Math.min(curMax[0], min[0]);
    //           return 0;
    //       }
    //       visited[x][y] = true;
    //       for(int[] dir: direction){
    //
    //           Integer cur = dfs(matrix,min,x+dir[0], y+dir[1],row, column, visited);
    //           curMax = Math.max(curMax, cur);
    //       }
    //       visited[x][y] = false;
    //       return curMax;
    //   }
}
