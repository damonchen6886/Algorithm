package DFS;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithDuplicates {

    // 1. How many states do we have -> (how many level do we need)
// 2. How many different states should we try to put on each level
//
//			                               []
//             1                    /            \
//                                [1]             []
//             2               /      \         /    \
//                        [1,2]       [1]      [2]    []
//             3          /    \      /  \    /  \    / \
//                      [1,2,3][1,2][1,3][1] [23][2] [3] []


    // if contains duplicates:
    // [1,1,2,3,]
    // expect: [ [1][2][3][11][12][13][23][112][113][123][1123][] ]
//
//                      []
//           1         /  \
//                   [1]     []
//           1       /\      / \
//                 [11] [1] [1] []
//           2      /\       ^ -----------------------------------------------------------
//               [112][11][12][1] [12][1][2][]                                           |
//           3     / \                                                                   |
//               [1123][112][113][11][123][12][13][1][123][12][13][1][23][2][3][]        |
//                                                    ||   ||  ||  ||                    |
//                                                                                       |
//  Remove the 1. this is the cause of the duplicate of result. --------------------------
//                                             []
//          a                        /                  \
//                                 [a]                   []
//          b               /              \
//                       [ab]              [a]        ..........
//          b          /     \             /  \
//                 [abb]     [ab]      [ab]     [a]   ..........
//          c       /  \     /   \     /   \    / \
//             [abbc] [abb][abc][ab][abc] [ab][ac][a] ........
//
//
//                                            []
//          a                        /                  \
//                                 [a]                   []
//          b               /              \
//                       [ab]              [a]        ..........
//          b          /     \              |
//                 [abb]     [ab]           |     ..........
//          b                 |             |
//          b                 |             |
//          .                 |             |
//          .                 |             |
//          .                 |             |
//                            |             |
//          c       /  \      / \          /\
//             [abbc] [abb] [abc][ab]     [ac][a] ........



//  */


    public static List<List<Integer>> subSetDuplicate(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        List<List<Integer>>  result = new ArrayList<>();

        dfs(0,new ArrayList<Integer>(), arr, result);
        return result;
    }
    private static void dfs(int level, List<Integer> cur, int[] arr, List<List<Integer>> result){
        if(level == arr.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }

        cur.add(arr[level]);
        dfs(level+1, cur, arr, result);
        cur.remove(cur.size()-1);
        // remove duplicate
        //---------------------------------------------------------------------|
        while(level < arr.length -1 && arr[level] == arr[level+1]) level++;//  |
        //---------------------------------------------------------------------|
        dfs(level+1, cur, arr, result);

    }



    public static void main(String[] args) {
        System.out.println("Hello, world!");
        int[] array = new int[]{1,1,2,3};
        List<List<Integer>> result = subSetDuplicate(array);

        System.out.println(result);
    }

}
