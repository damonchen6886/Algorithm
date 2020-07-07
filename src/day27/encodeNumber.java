package day27;

public class encodeNumber {
    //A message containing letters fromA-Zis being encoded to numbers using the following mapping:
    //'A' -> 1
    //'B' -> 2
    //...
    //'Z' -> 26
    //Given a non-empty string containing only digits, determine the total number of ways to decode it.
    //Example 1:
    //Input: "12"
    //Output: 2
    //Explanation: It could be decoded as "AB" (1 2) or "L" (12).
    //Example 2:
    //Input: "226"
    //Output: 3
    //Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    public int decodeWays(String s){
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int[] dp = new int[array.length+1];
        // base case
        dp[0] = 1;
        for(int i = 1; i <= array.length; i++){
            dp[i] = dp[i-1] * countSingle(array[i-1]);
            if(i > 1){
                dp[i] += dp[i-2] * countDouble(array[i-2],array[i-1]);
            }
        }
        return dp[array.length];
    }
    private int countSingle(char c){
        return c-'0' == 0 ? 0 : 1;
    }
    private int countDouble(char t, char s){
        if(t == '1' || (t == '2' && s <= '6')) return 1;
        else return 0;
    }


//    A message containing letters fromA-Zis being encoded to numbers using the following mapping:
//            'A' -> 1
//            'B' -> 2
//            ...
//            'Z' -> 26
//    Input: "*"
//    Output: 9
//    Explanation: You can change it to "1", "2", "3", "4", "5", "6", "7", "8", "9".
//    Input: "1"
//    Output: 18
public long decodeWays2(String s){
    if(s == null || s.length() == 0) {
        return 0;
    }
    char[] array = s.toCharArray();
    long[] dp = new long[array.length+1];
    // base case
    dp[0] = 1;
    for(int i = 1; i <= array.length; i++){
        dp[i] = dp[i-1] * countSingle2(array[i-1]);
        if(i > 1){
            dp[i] += dp[i-2] * countDouble2(array[i-2],array[i-1]);
        }
    }
    return dp[array.length];
}
    private int countSingle2(char c){
        if(c == '*'){
            return 9;
        } else if(c == '0'){
            return 0;
        } else return 1;
    }
    private int countDouble2(char t, char s){
        if(t == '0'){
            return 0;
        }
        if(t == '1'){
            if(s == '*'){
                return 9;
            } else {
                return 1;
            }
        }
        if(t == '2'){
            if(s == '*'){
                return 6;
            } else if (s <= '6'){
                return 1;
            } else {
                return 0;
            }
        }
        if(t >= '3' && t <= '9'){
            return 0;
        }
        // t == '*'
        if(s >= '0' && s <= '6'){
            return 2;
        }
        if(s >= '7' && s <= '9'){
            return 1;
        }
        // **
        return 15;

    }

}
