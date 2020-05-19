package day4;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

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


    public List<String> subSet(int[] array){
        List<String> result = new ArrayList<String>();
        if(array == null || array.length == 0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(array, sb, 0, result);
        return result;
    }
    private void dfs(int[] array, StringBuilder sb, int level, List<String> result){
        // base case
        if(level == array.length){
            result.add(sb.toString());
            return;
        }
        // recursion rules
        // case 1.0 do not pick

        dfs(array, sb, level + 1, result);
        // case 1.1 pick the corresponding int
        dfs(array, sb.append(array[level]), level + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }

}
