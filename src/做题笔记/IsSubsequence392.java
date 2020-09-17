package 做题笔记;

public class IsSubsequence392 {
    //Given a string s and a string t, check if s is subsequence of t.
    //
    //A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
    //
    //Follow up:
    //If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

    // two pointer:
    public boolean isSubsequence0(String s, String t) {
        if(s == null || s.length() ==0){
            return true;
        }
        int n = s.length();
        int m = t.length();
        int left = 0;
        int right = 0;
        int count = 0;
        for(int i = 0; i< m; i++){
            if(s.charAt(left) == t.charAt(right)){
                left++;
                count++;
                if(count == n){
                    return true;
                }

            }
            right++;
        }
        return false;

    }
    //一维dp
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() ==0){
            return true;
        }
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m+1];

        for(int i =1; i <= n;i++){
            for(int j = 1; j<= m;j++){
                if((s.charAt(i-1) ==t.charAt(j-1))){
                    dp[j] = dp[j-1]+1;
                }
                else{
                    dp[j] = Math.max(dp[j],dp[j-1]);

                }
                if(dp[m] ==n){
                    return true;
                }
            }
        }
        return false;

    }
    //二维dp
    public boolean isSubsequence2(String s, String t) {
        if(s == null || s.length() ==0){
            return true;
        }
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[m+1][n+1];

        for(int i =1; i <= n;i++){
            for(int j = 1; j<= m;j++){
                if((s.charAt(i-1) ==t.charAt(j-1))){
                    dp[j][i] = dp[j-1][i-1]+1;
                }
                else{
                    dp[j][i] = Math.max(dp[j][i-1],dp[j-1][i]);

                }
                if(dp[m][n] ==n){
                    return true;
                }
            }
        }
        return false;

    }
}
