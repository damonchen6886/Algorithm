package 做题笔记.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithAllWords30 {
    //You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s)
    // in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
    //You can return the answer in any order.
    //
    //
    //Input: s = "barfoothefoobarman", words = ["foo","bar"]
    //Output: [0,9]
    //Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
    //The output order does not matter, returning [9,0] is fine too.
    //Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
    //Output: []
    //Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
    //Output: [6,9,12]

    //思路： 用一个hashmap来存所有list里面的东西 然后 用另外一个hashmap来存s从i开始的所有满足条件的substring， 如果substring满足 就加startIndex，
    //不满足就直接break  这样如果startIndex遍历完就说明 s里面有满足条件 在吧这个满足条件的index 加入结果集就行了
    // 加入的i 不是 startIndex
    // 例子  "barfoothefoobarman", words = ["foo","bar"]
    // 这里 我们只需要遍历s的长度和words的长度的差值 就可以吧所有情况都遍历完了
    // 从每一个index开始 来查找 wordmap里面是否包含s的substring 如果没有说明从i开始 没有条件成立的答案， i++，
    // 如果有 就继续遍历直到startIndex 和wordList的长度相等， 然后把加入结果集

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String,Integer> wordsMap = new HashMap<>();
        int listLength = words.length;
        for(int i = 0; i < listLength;i++){
            wordsMap.put(words[i], wordsMap.getOrDefault(words[i],0)+1);
        }
        int wordLength = words[0].length();
        int allLength = listLength * wordLength;
        for(int i = 0; i < s.length() - allLength+1; i++){
            HashMap<String,Integer> visited = new HashMap<>();
            int startIndex;
            for(startIndex =0; startIndex < listLength; startIndex++){
                String cur = s.substring(i+ startIndex * wordLength, i +( startIndex +1) *wordLength);
                if(wordsMap.containsKey(cur)){
                    visited.put(cur, visited.getOrDefault(cur,0)+1);
                    if(visited.get(cur) > wordsMap.get(cur)){
                        break;
                    }
                }
                else{
                    break;
                }
            }
            if(startIndex == listLength){
                result.add(i);
            }
        }
        return result;

    }
}
