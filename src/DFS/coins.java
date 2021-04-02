package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class coins {
    //     Arguments
// 	coins - an array of positive integers representing the different denominations of coins
// 	 		there are no duplicate numbers and the numbers are sorted by descending order
// 	 		eg. {25, 10, 5, 2, 1}
// 	target - a non-negative integer representing the target number of cents, eg. 99
// * Assumptions
// 	coins is not null and is not empty, all the numbers in coins are positive
// 	target >= 0
// 	You have infinite number of coins for each of the denominations,
// 	you can pick any number of the coins.
// * Return
// 	a list of ways of combinations of coins to sum up to be target.
// 	each way of combinations is represented by list of integer
// 	the number at each index means the number of coins used for the denomination at corresponding index.
// * Examples
// 	coins = {2, 1}, target = 4, the return should be
// 	[ [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
// 	  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
// 	  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)]

    //                             []

//             [2]             [1]
//            [2][1]          [1]

    // O(arr.length^target/min(arr))

    public static List<List<Integer>> coins(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur =  new ArrayList<Integer>(Collections.nCopies(arr.length,0));
        dfs4(arr, target,cur , 0,result );
        return result;
    }

    private static void dfs4(int[] arr, int target, List<Integer> cur, int start, List<List<Integer>> result){
        if(target < 0){
            return;
        }
        if( target == 0){
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int  i = start; i < arr.length; i++){
            cur.set(i,cur.get(i)+1);
            dfs4(arr, target-arr[i], cur, i, result);
            cur.set(i,cur.get(i)-1);

        }
    }

    public static void main(String[] args) {

        System.out.println("Hello, world!");

        System.out.println(coins(new int[]{1,2}, 4));
    }

}
