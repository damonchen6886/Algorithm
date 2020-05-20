package day5;

//3.1  Permutations
//Given a collection of distinct integers, return all possible permutations.
//Input:
//[1,2,3]
//Output:
//[
//[1,2,3],
//[1,3,2],
//[2,1,3],
//[2,3,1],
//[3,1,2],
//[3,2,1]
//]

//
//          position 1            [1]  [2]     [3]   3
//          position 2         [2][3]  [1][3]  [1][2]   3*2
//          position 3         [3] [2] [3] [1] [2] [1]    3*1

//         answer: [123][132][213][231][312][321]

import java.util.ArrayList;
import java.util.List;

public class Permutations {


    public static List<List<Integer>> permutation(int[] array){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array == null || array.length == 0) return result;
        // parsing parameter: 1. given array, 2. current answer 3 result, 4, level(for base case)
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] used = new boolean[array.length];
        dfs(array, result,  cur, used);
        return result;
    }
    private static void dfs(int[] array, List<List<Integer>> result, List<Integer> cur, boolean[] used){
        // base case:
        if(cur.size() == array.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < array.length; i++){
            if(!used[i]){
                // deside to use array[i]
                used[i] = true;
                cur.add(array[i]);
                dfs(array, result, cur,used);
                // handle backtracking problem
                cur.remove(cur.size()-1);
                used[i] = false;
            }
        }
    }



    public static List<List<Integer>> permutation2(int[] array){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array == null || array.length == 0) return result;
        // parsing parameter: 1. given array, 2. current answer 3 result, 4, level(for base case)
        List<Integer> cur = new ArrayList<Integer>();
        int level = 0;
        dfs2(array, result,  cur, level);
        return result;
    }

    private static void dfs2(int[] array, List<List<Integer>> result, List<Integer> cur,int level ){
        // base case:
        if(cur.size() == array.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = level; i < array.length; i++){
            cur.add(array[i]);
            dfs2(array, result, cur, level + 1);
            cur.remove(cur.size()-1);
        }
    }



    public static List<List<Integer>> permutation3(int[] array){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array == null || array.length == 0) return result;
        // parsing parameter: 1. given array, 2. current answer 3 result, 4, level(for base case)
        List<Integer> cur = new ArrayList<Integer>();
        int level = 0;
        dfs3(array, result,  cur, level);
        return result;
    }


    private static void dfs3(int[] array, List<List<Integer>> result, List<Integer> cur,int level ){
        // base case:
        if(cur.size() == array.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < array.length; i++){
            cur.add(array[i]);
            dfs3(array, result, cur, level + 1);
            cur.remove(cur.size()-1);
        }
    }


    public static List<List<Integer>> permutation4(int[] array){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array == null || array.length == 0) return result;
        // parsing parameter: 1. given array, 2. current answer 3 result, 4, level(for base case)
        List<Integer> cur = new ArrayList<Integer>();
        int level = 0;
        dfs4(array, result,  cur, level);
        return result;
    }


    private static void dfs4(int[] array, List<List<Integer>> result, List<Integer> cur,int level ){
        // base case:
        if(cur.size() == array.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = level; i < array.length; i++){
            cur.add(array[i]);
            dfs4(array, result, cur, i);
            cur.remove(cur.size()-1);
        }
    }




    public static List<List<Integer>> permutation5(int[] array){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array == null || array.length == 0) return result;
        // parsing parameter: 1. given array, 2. current answer 3 result, 4, level(for base case)
        List<Integer> cur = new ArrayList<Integer>();
        int level = 0;
        dfs5(array, result,  cur, level);
        return result;
    }


    private static void dfs5(int[] array, List<List<Integer>> result, List<Integer> cur,int level ){
        // base case:
        if(cur.size() == array.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = level; i < array.length; i++){
            cur.add(array[i]);
            dfs5(array, result, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }



    public static List<List<Integer>> permutation6(int[] array){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array == null || array.length == 0) return result;
        // parsing parameter: 1. given array, 2. current answer 3 result, 4, level(for base case)
        List<Integer> cur = new ArrayList<Integer>();
        int level = 0;
        dfs6(array, result,  cur, level);
        return result;
    }


    private static void dfs6(int[] array, List<List<Integer>> result, List<Integer> cur,int level ){
        // base case:
        if(cur.size() == array.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = level; i < array.length; i++){
            cur.add(array[i]);
            dfs6(array, result, cur, level);
            cur.remove(cur.size()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello, world!");
        int[] array = new int[]{1,2,3};
        List<List<Integer>> result = permutation(array);
        System.out.println("permutation1 = " + result);

        List<List<Integer>> result2 = permutation2(array);
        System.out.println("permutation2 = " + result2);

        List<List<Integer>> result3 = permutation3(array);
        System.out.println("permutation3 = " + result3);

        List<List<Integer>> result4 = permutation4(array);
        System.out.println("permutation4 = " + result4);

        List<List<Integer>> result5 = permutation5(array);
        System.out.println("permutation5 = " + result5);

        List<List<Integer>> result6 = permutation6(array);
        System.out.println("permutation6 = " + result6);


    }


// level + 1:
//[[1, 2, 3], [1, 3, 3], [2, 2, 3], [2, 3, 3], [3, 2, 3], [3, 3, 3]]
// i:
//[[1, 1, 1], [1, 1, 2], [1, 1, 3], [1, 2, 2], [1, 2, 3], [1, 3, 3], [2, 2, 2], [2, 2, 3], [2, 3, 3], [3, 3, 3]]
// i+1:
//[[1, 2, 3]]


}
