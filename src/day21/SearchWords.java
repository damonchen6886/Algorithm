package day21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchWords {


    public boolean twoDboard(String[] args, String s){
        if(args == null || args.length == 0){
            return false;
        }
        int row = args.length;
        int column = args[0].length();
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(args[i].charAt(j) == s.charAt(0)){
                    queue.offer(new Point(i,j,s.charAt(0)));
                    visited[i][j] = true;

                }

            }
        }
        if(queue.isEmpty()){
            return false;
        }

        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
            sb.append(s.charAt(0));
        int level = 1; // match the index of given string
        while(!queue.isEmpty()){
            int size = queue.size();
            char c = s.charAt(level);
 //           System.out.println("sb is = " + sb);
//            sb = new StringBuilder();
//            sb.append(s.charAt(0));
            for(int k = 0; k < size; k++){
                Point p = queue.poll();
                visited[p.x][p.y] = true;


                for(int i = 0; i < direction.length; i++){
                    int x = p.x+ direction[i][0];
                    int y = p.y + direction[i][1];

                    if(x >0 && x< row && y> 0 && y< column && !visited[x][y]){
                        if( sb.length() < s.length()){
                                System.out.println("args[x].charAt(y) " + args[x].charAt(y));
                                System.out.println("s.charAt(sb.length()) " + s.charAt(sb.length()));
                            if( args[x].charAt(y) == s.charAt(sb.length())){
                                sb.append(args[x].charAt(y));
                                visited[p.x][p.y] = true;
                            }
                        }
                        queue.offer(new Point(x,y,args[x].charAt(y)));

                        if(sb.length() == s.length()){
                            System.out.println("sb equal = " + sb);
                            return true;
                        }
                    }
                }

            }
        }
            return false;

    }




    public boolean exist(char[][] board, String word){
        // corner case
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        // you should make assumption with interviewer
        if(word.length() == 0){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // pure dfs
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(helper(board, visited, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, boolean[][] visited, int i, int j, String word, int index){
        // base case 1: if already find the answer
        if(index == word.length()) return true;
        // base case 2: out of boundary
        if(i < 0 || j < 0 || i > board.length || j > board[0].length){
            return false;
        }
        // base case 3: they do not match
        if(word.charAt(index) != board[i][j] || visited[i][j]){
            return false;
        }
        // dfs
        visited[i][j] = true;
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        for(int k = 0; k < dx.length; k++){
            if(helper(board, visited, i + dx[k], j + dy[k], word, index + 1)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }


    // dfs
    public boolean twoDboard2(char[][] board, String s){
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        List<Point> Plist = findhead(board, s);
        boolean result;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < Plist.size(); i++){
            return dfs(board, s, visited, Plist.get(i), 0);

        }
        return false;
    }


    //dfs
    private boolean dfs(char[][] board,String s, boolean[][] visited, Point p, int level){
        //
        if(s.charAt(level) != board[p.x][p.y] || visited[p.x][p.y] || p.x >=  board.length || p.x < 0 || p.y< 0 || p.y >= board[0].length){
            return false;
        }
        if(level == s.length()){
            return true;
        }
        visited[p.x][p.y] = true;
        int[][] direction ={{1,0},{-1,0},{0,-1},{0,1}};
        for(int i = 0;  i < direction.length; i++){
            int  x = p.x+ direction[i][0];
            int y = p.y + direction[i][1];
             p = new Point(x,y,board[x][y]);
            if(dfs(board, s, visited, p, level+1)){
                return true;
            }
        }
        return false;
    }

    private List<Point> findhead(char[][] board, String s){
        List<Point> p = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == s.charAt(0)){
                    p.add(new Point(i,j, s.charAt(0)));
                }

            }
        }
        return  p;
    }




        class Point{
            int x;
            int y;
            char c;
            public Point(int x, int y, char c){
                this.x = x;
                this.y = y;
                this.c =c;
            }
        }


    public static void main(String[] args) {
        String[] board ={"ABCE","SFCS","ADEE"};
        SearchWords search = new SearchWords();
//        System.out.println("expected = true : actual = "+ search.twoDboard(board, "SEE"));
//        System.out.println("expected = true : actual = "+ search.twoDboard(board, "AS"));
//       System.out.println("expected = true : actual = "+ search.twoDboard(board, "FDEE"));
        System.out.println("expected = true : actual = "+ search.twoDboard(board, "ABCCED"));
//        System.out.println("expected = false : actual = "+ search.twoDboard(board, "ABCB"));
    }

}
