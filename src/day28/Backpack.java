package day28;

import java.util.Arrays;

public class Backpack {
    //
    //
    //Question
    //Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
    //Notice
    //You can not divide any item into small pieces.
    //Example
    //If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.
    //You function should return the max size we can fill in the given backpack.



    // pure dp approach:
    public int backPack(int[] array, int size){
        int[][] dp = new int[array.length + 1][size + 1];
        for(int i = 1; i <= array.length; i++){
            for(int j = 1; j <= size; j++){
                if(j >= array[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-array[i-1]] + array[i]-1);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[array.length][size];
    }

    // Memory search
    int result = Integer.MIN_VALUE;
    public int memBackPack(int[] array, int size){
        Arrays.sort(array);

        int[] mem = new int[array.length];
        memSearch(size, array, 0, mem);
        return result;
    }
    private int memSearch(int size, int[] array, int start, int[] mem){
        // base case
        if(mem[start] > 0){
            return mem[start];
        }
        //
        int result = 0;
        for(int i = start; i < array.length; i++){
            if(size - array[i] >= 0){
                result = Math.max(result, memSearch(size - array[i], array, start + 1, mem));
            }
        }
        mem[start] = result;
        return result;
    }

    // pure dfs approach
    int r = 0;
    public int backpackDFS(int[] array, int size){
//        int result = 0;
        if(array == null || array.length == 0){
            return 0;
        }

        Arrays.sort(array);
        dfs(array, size, 0, 0);
        return r;
    }
    private void dfs(int[] array, int size, int level, int curValue){
        // base case
        if(curValue > size){
            return;
        }
        if(level ==array.length){
            r = Math.max(r, curValue);
        }
//        int result = Integer.MIN_VALUE;
        for(int i = level; i <array.length; i++){
            curValue += array[i];
            dfs(array, size, level+1, curValue);
            curValue -=array[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,10,19,37,30,11,35,16,49};
        int max = 49;
        Backpack b = new Backpack();
        System.out.println(b.backPack(arr, max));
    }

}
