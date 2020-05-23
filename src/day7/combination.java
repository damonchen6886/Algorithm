package day7;

import java.util.ArrayList;
import java.util.List;

public class combination {

// Medium
// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
// Example:
// Input:
// n = 4, k = 2
// Output:
// [
//  [2,4],[3,4],[2,3],[1,2],[1,3],[1,4],
// ]

    public static List<List<Integer>> combination(int n, int k ){
        if(n <= 0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> cur = new ArrayList<>();

        int[] arr= new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;

        }


        dfs(arr, n, k, result, cur);

        return result;
    }


    private static void dfs(int[] arr, int n, int k, List<List<Integer>> result, List<Integer> cur){
        if(cur.size() == k){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(!cur.contains(1)){return;}
        for(int i = 0;  i < n; i++){
            cur.add(arr[i]);
            dfs(arr, i, k, result, cur);
            cur.remove(cur.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println(combination(4,2));
    }

}
