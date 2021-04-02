package DFS;

import java.util.ArrayList;
import java.util.List;

public class eightQueens {

    //
//Given an integern, return all distinct solutions to then-queens puzzle.
//Each solution contains a distinct board configuration of then-queens' placement,
// where'Q'and'.'both indicate a queen and an empty space respectively.

    public static List<List<Integer>> nQueens(int n){
        if( n <= 0){
            return null;
        }
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(n,result,cur);
        return result;


    }


    private static void dfs(int n, List<List<Integer>> result, List<Integer> cur){
        if(cur.size() == n){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i< n; i++){
            if(valid(cur, i)){ //
                cur.add(i);
                dfs( n, result, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private static boolean valid(List<Integer> cur, int column){
        int row = cur.size();
        for(int i = 0; i < row; i++){
            // k = y2 - y1 / x2 - x1
            if(cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i){
                return false;
            }

        }
        return  true;
    }
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        // System.out.println(combine(4,2));
        System.out.println(nQueens(4));
    }


}
