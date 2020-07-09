package day28;

public class backpack4 {

    //Description
    //Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
    //Each item may be chosen unlimited number of times
    //Example
    //Given candidate items[2,3,6,7]and target7,
    //A solution set is:
    //[7]
    //[2, 2, 3]

    public int backPackII(int[] weight, int size){
        int[][] dp = new int[weight.length + 1][size + 1];
        int count =0;
        int curMax = 0;
        for(int i = 1; i <= weight.length; i++){
            for(int j = 1; j <= size; j++){
                if(j >= weight[i-1]){
                    if(dp[i-1][j]< dp[i][j-weight[i-1]] && dp[i][j-weight[i-1]]== curMax){
                        count++;
                    }
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weight[i-1]]);
                    if(curMax < dp[i][j]){
                        curMax = dp[i][j];
                        count = 1;
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return count;
    }

    //Description
    //Given n items with sizenums[i] which an integer array and all positive numbers. An integertargetdenotes the size of a backpack. Find the number of possible fill the backpack.
    //Each item may only be used once
    //Example
    //Given candidate items[1,2,3,3,7]and target7,
    //A solution set is:
    //[7]
    //[1, 3, 3]



}
