package DynamicProgramming;

import java.util.*;

public class WordBreak {
//Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
//
//Note that the same word in the dictionary may be reused multiple times in the segmentation.
    //Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    //Output: ["cats and dog","cat sand dog"]

//    Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
//    Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//    Explanation: Note that you are allowed to reuse a dictionary word.
public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    Map<String, List<String>> map =new HashMap<>();
    return dfs(map, s, set);
}

    private List<String> dfs(Map<String, List<String>> map, String s, Set<String> set){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String>result = new ArrayList<>();
        if(set.contains(s)){
            result.add(s);
        }
        for(int i = 1; i< s.length();i++){
            String head = s.substring(0,i);
            if(set.contains(head)){
                String rest = s.substring(i);
                List<String> subList = dfs(map, rest,set);
                for(String cur: subList){
                    result.add(head + " " + cur);
                }
            }
        }
        map.put(s,result);
        return result;
    }

    public static void main(String[] args) {
        List<String> l1 = new ArrayList(List.of("cat","cats","and","sand","dog"));
        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak("catsanddog",l1));
    }

}
