package DynamicProgramming;

public class LongestCommonSubsequence {
//    Find the length of longest common subsequence of two given strings.
//
//        Assumptions
//
//        The two given strings are not null
//        Examples
//
//        S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.

    public int LCS(String s1, String s2){
        if(s1 == null || s2 == null){
            return 0;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2 +1];
        for(int  i = 0; i < l1+1; i++){
            for(int j = 0; j < l2+1; j++){
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }





//
}
