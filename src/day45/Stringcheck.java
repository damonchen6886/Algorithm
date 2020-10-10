package day45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//        Given an array of strings, return all groups of strings that are anagrams.
// *		All inputs will be in lower-case.
// *		Input:
// *			s: "cbaebabacd" p: "abc"
// *		Output:
// *			[0, 6]
// *		The substring with start index = 0 is "cba", which is an anagram of "abc".
// *		The substring with start index = 6 is "bac", which is an anagram of "abc".
//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
public class Stringcheck {
    // Time: O(n) sliding window
    public List<Integer> findAnagrams(String[] strs){
        if(strs == null || strs.length != 2 || strs[0].length() < strs[1].length()){
            return new ArrayList<Integer>();
        }
        // step 1: build map
        Map<Character, Integer> map = buildMap(strs[1]);
        List<Integer> result = check(strs[0], strs[1], map);
        return result;
    }

    // key:xxx, value: hashmap, list
    private Map<Character, Integer> buildMap(String string){
        Map<Character, Integer> map = new HashMap<>();
        char[] array = string.toCharArray();
        for(char c : array){
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    private List<Integer> check(String source, String pattern, Map<Character, Integer> map){
        List<Integer> result = new ArrayList<Integer>();
        int left = 0, matchCount = 0;
        for(int right = 0; right < source.length(); right++){
            // step 1: check the boundary
            if(right - left >= pattern.length()){
                // handle the left side
                if(map.containsKey(source.charAt(left))){
                    if(map.get(source.charAt(left))== 0){
                        matchCount--;
                    }
                    map.put(source.charAt(left),map.getOrDefault(source.charAt(left),0) + 1);
                }
                left++;
            }
            // handle the right side
            char r = source.charAt(right);
            if(map.containsKey(r)){
                if(map.get(r) == 1){
                    matchCount++;
                }
                map.put(r, map.get(r) - 1);
            }
            if(matchCount == map.size()){
                result.add(left);
            }
        }
        return result;
    }

    //------------------------------------------------
    // Time: O(p! * n*n)
    public List<Integer> anagrams(String[] strings){
        List<Integer> result = new ArrayList<>();
        List<String> plst = permutation(strings[1]);
        for(int i =0; i < plst.size();i++){
            String cur = plst.get(i);
            // [0,5] [8,10]
            List<Integer> curResult = check(strings[0], cur);
            for(int j = 0; j < curResult.size();j++){
                result.add(curResult.get(j));
                //[0,5,8,10]
            }
        }
        return result;

    }
    private List<Integer> check(String s, String p){
        List<Integer> result = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == p.charAt(index++)){

            }
            else if(s.charAt(i) != p.charAt(index)){
                index =0;
            }
            if(index == p.length()){
                result.add(i);
            }
        }
        return result;

    }


    private List<String> permutation(String s){
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        StringBuilder cur = new StringBuilder();
        dfs(s, result, visited,0, cur);
        return result;
    }
    private void dfs(String s, List<String> result, boolean[] visited, int level, StringBuilder cur){
        if(level == s.length()){
            if(!result.contains(cur)){
                result.add(cur.toString());
                return;
            }
        }
        for(int i = 0; i < s.length();i++){
            if(!visited[i]){
                cur.append(s.charAt(i));
                visited[i] = true;
                dfs(s, result, visited, level, cur);
                cur.setLength(cur.length()-1);
                visited[i] = false;
            }
        }
    }
}
