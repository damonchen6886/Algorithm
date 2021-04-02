package _2dfs.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination {


    public static List<List<Integer>> combinationSum(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        dfs(arr, target, new ArrayList<>(), 0,result );
        return result;
    }

    private static void dfs(int[] arr, int target, List<Integer> cur, int start, List<List<Integer>> result){
        if(target < 0){
            return;
        }
        if( target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int  i = start; i < arr.length; i++){
            if((target-arr[i]) >= 0 ){

                cur.add(arr[i]);

                dfs(arr, target-arr[i], cur, i, result);
                cur.remove(cur.size()-1);

            }

        }
    }




//                             []

//             [2]            [3]            [6]            [7]
//         [2][3][6][7]  [3][6][7]          [6][7]


// result:  4  5  8  7    5  6  9 10    8 9  12 13     9  10  13 14
// follow up 1, what if each element can only be used once and array contains duplicates.


    public static List<List<Integer>> combinationSum2(int[] arr, int target){


        if(arr == null || arr.length == 0){
            return null;
        }
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        dfs2(arr, target, new ArrayList<>(), 0,result );
        return result;
    }

    private static void dfs2(int[] arr, int target, List<Integer> cur, int start, List<List<Integer>> result){
        if(target < 0){
            return;
        }
        if( target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int  i = start; i < arr.length; i++){
            if((target-arr[i]) >= 0 ){

                cur.add(arr[i]);

                dfs2(arr, target-arr[i], cur, i+1, result);
                cur.remove(cur.size()-1);

                while(i < arr.length -1 && arr[i] == arr[i+1]) i++;//
            }

        }
    }


    //                             []

//             [2]            [3]            [6]            [7]
//         [3][6][7]          [6][7]         [7]

    //      while(level < arr.length -1 && arr[level] == arr[level+1]) level++;//


    // Follow Up 2: Given an integer array with all positive numbers and no duplicates, find the number of
    // possible combinations that add up to a positive integer target. (permutation of combination)
    // The possible combination ways are: (Note that different sequences are counted as different combinations.)
    // (1, 1, 1, 1)
    // (1, 1, 2)
    // (1, 2, 1)
    // (1, 3)
    // (2, 1, 1)
    // (2, 2)
    // (3, 1)
    // You can see the difference between Follow Up 1

    public static List<List<Integer>> combinationSum3(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        dfs3(arr, target, new ArrayList<>(), 0,result );
        return result;
    }

    private static void dfs3(int[] arr, int target, List<Integer> cur, int start, List<List<Integer>> result){
        if(target < 0){
            return;
        }
        if( target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int  i = 0; i < arr.length; i++){


            cur.add(arr[i]);

            dfs3(arr, target-arr[i], cur, i, result);
            cur.remove(cur.size()-1);



        }
    }



    public static void main(String[] args) {

        System.out.println("Hello, world!");
        System.out.println(combinationSum(new int[]{1,2,3,6,7}, 7));
        System.out.println(combinationSum2(new int[]{1,2,2,3,5,6,7}, 10));
        System.out.println(combinationSum3(new int[]{1,2,3}, 4));
        int[] a = {1,2,3};
        int[] b = new int[3];
        b[2] = a[2];
        a[2] =6;
        System.out.println(b[2]);


    }




}
