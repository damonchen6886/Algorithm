package day23;

import java.util.HashSet;
import java.util.Set;

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
    //Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"  "ro"


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

}
