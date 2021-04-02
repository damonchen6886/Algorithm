package _2dfs.day6;

import java.util.ArrayList;
import java.util.List;

public class parenthesis {

    // given n pair of parenthesis and print all valid possible combinations
    public static List<String> parenthesis(int n){
        // n represent n paris of parenthesis
        List<String> res = new ArrayList<String>();
        if(n<0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(n, res, sb, 0, 0);
        return res;
    }
    // left: n   right : n  , left > right
    private static void dfs(int n, List<String> res, StringBuilder sb, int left, int right){
        // base case:
        if(left == n && right == n){
            // level == 2n
            res.add(sb.toString());
            return;
        }
        // recursion rule
        // pick "(", pruning condition
        if(left < n){
            dfs(n, res, sb.append('('), left+1, right);
            sb.deleteCharAt(sb.length()-1);
        }

        // pick ")"
        if(right < n && right < left){
            dfs(n, res, sb.append(')'), left, right+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }


    public static void main(String[] args) {

        int[] test  = new int[]{1,1,2};
        int test2  = 2;
        List<String> result = parenthesis(test2);
        for(String s : result){
            System.out.println(s);
        }
    }

}
