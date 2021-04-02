package DFS;

import java.util.ArrayList;
import java.util.List;

public class coins2 {


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

    // O(target/min(arr)^arr.length)
    public static List<List<Integer>> coinsI(int[] array, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs7(target, array, 0, result, cur);
        return result;
    }

    private static  void dfs7(int target, int[] coins, int level, List<List<Integer>> result, List<Integer> cur){
        // new version of base case
        if(level == coins.length - 1){
            if(target % coins[level] == 0){
                cur.add(target/coins[level]);
                result.add(new ArrayList<>(cur));
                cur.remove(cur.size()-1);
            }
            return;
        }
        int max = target/coins[level];
        for(int i = 0; i <= max; i++){
            cur.add(i);
            dfs7(target-i*coins[level], coins, level+1, result, cur);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello, world!");
//       System.out.println(combinationSum(new int[]{1,1,2,3,6,7}, 7));
        // System.out.println(combinationSum2(new int[]{1,2,2,3,5,6,7}, 10));
        // System.out.println(combinationSum3(new int[]{1,2,3}, 4));
        // System.out.println(coins(new int[]{25,10, 5, 2,1}, 99));
        System.out.println(coinsI(new int[]{2,1}, 4));
    }
}
