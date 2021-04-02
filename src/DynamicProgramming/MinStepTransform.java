package day23;

public class MinStepTransform {

    //Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.
    //
    //Assumptions
    //
    //Both strings are not null
    //Examples
    //
    //string one: “sigh”, string two : “asith”
    //
    //the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).

    public int editDistance(String one, String two){
        if(one == null || two == null){
            return 0;
        }
        int[][] distance = new int[one.length()+1][two.length()+1];
        for(int i = 0; i <= one.length(); i++){
            for(int j = 0; j <= two.length(); j++){
                if(i == 0 || j == 0){
                    distance[i][j] = (i == 0) ? j : i;
                } else if(one.charAt(i-1) == two.charAt(j-1)){
                    distance[i][j] = distance[i-1][j-1];
                } else {
                    distance[i][j] = Math.min(distance[i-1][j-1]+1, distance[i-1][j]+1);
                    distance[i][j] = Math.min(distance[i][j-1]+1, distance[i][j]);
                }
            }
        }
        return distance[one.length()][two.length()];
    }

    public int countSteps(String a, String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for(int i = 1; i < a.length(); i++){
            dp[i][0] = i;
            for(int j = 1; j < b.length(); j++){
                dp[0][j] = j;
                if(a.charAt(i) != b.charAt(j)){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }

            }
        }
        return dp[a.length()][b.length()];

    }



}


