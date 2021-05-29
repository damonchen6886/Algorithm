package DynamicProgramming;

import java.util.*;

public class ConcatenateWord {
    //Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
    //
    //Assumptions
    //
    //The given word is not null and is not empty
    //The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
    //Examples
    //
    //Dictionary: {“bob”, “cat”, “rob”}
    //
    //Word: “robob” return false
    //
    //Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"


    public boolean canBreak(String input, String[] dict){
        Set<String> d = new HashSet<>();
        for(String s:dict){
            d.add(s);
        }
        boolean[] dp = new boolean[input.length()+1];
        dp[0] = true;
        for(int i = 1; i <= input.length(); i++){
            for(int j = 0; j < i; j++){
                if(d.contains(input.substring(j, i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
    public boolean canbreak2(String input, List<String> dict){
        Set<String> set = new HashSet<>(dict);
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(0);
        boolean[] visited= new boolean[input.length()];
        while(!q.isEmpty()){
            int start = q.poll();
            if(!visited[start]){
                for(int end = start+1; end <= input.length(); end++){
                    if(set.contains(input.substring(start,end))){
                        q.offer(end);
                        if(end == input.length()){
                            return true;
                        }
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    // dfs with dp
    public boolean canbreak3(String input, List<String> dict){
        Set<String> set= new HashSet<>(dict);
        boolean[] dp = new boolean[input.length()+1];
        return dfs(input, set, dp, 0);
    }
    private boolean dfs(String input, Set<String> set, boolean[] dp, int start){
        if(start == input.length()){
            return true;
        }
        if(dp[start]){
            return dp[start];
        }
        for(int end = start+1; end<= input.length();end++){
            if(set.contains(input.substring(start, end))&& dfs(input, set,dp,end)){
                return dp[start] = true;
            }
        }
        return dp[start]  =false;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        List<String> dict2 = new ArrayList<>();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");
        ConcatenateWord c = new ConcatenateWord();
        System.out.println(c.canbreak3("applepenapple", dict));
        System.out.println(c.canbreak3("catsandog", dict2));
    }

}
