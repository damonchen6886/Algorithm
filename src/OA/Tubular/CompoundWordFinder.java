package OA.Tubular;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/***
 * Author: Chen Gu
 * gu.che@northeastern.edu
 * Date 4/25/2021
 * Time Complexity : O(mn^2) where m is the length of the list, n is word length
 *
 */
public class CompoundWordFinder {
    private HashSet<String> visited;

    public List<String>  compoundWordFinder(List<String> words) {
        TrieNode root =new TrieNode();
        List<String> result = new ArrayList<>();
        // deduplicate words
        HashSet<String> wordsSet = new HashSet<>(words);
        // two or less word should return nothing
        if(wordsSet.size() <=2){
            return result;
        }
        // create trie tree
        for(String word: wordsSet){
            // in case input has empty string, but it won't happen in stdin since scanner.next() skips empty string
            if(word.trim().equals("")){
                throw new IllegalArgumentException("Invalid input: empty string, Please enter a valid string");
            }
            insertWords(word.trim(),root);
        }
        // Iterate all the worlds
        for(String word: wordsSet) {
            visited = new HashSet<>();
            if (dfs(root, word.trim(), 0, 0)) {
                result.add(word.trim());
                System.out.println(word.trim());
            }
        }
//        System.out.println(result);
        return result;
    }

    // Search the word from the given input, each word should only use once as required
    private boolean dfs(TrieNode root, String word, int start, int component){
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < word.length();i++){
            char c = word.charAt(i);
            if(cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
            sb.append(c);
            if(cur.isWord  && visited.add(sb.toString())){
                if(dfs(root, word,i+1,  component+1)){
                    return true;
                }
                visited.remove(sb.toString());
            }

        }
        return component >=1 && cur.isWord && !visited.contains(sb.toString());
    }




    // Build the trie Tree
    class TrieNode{
        TrieNode[] children;
        boolean isWord = false;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    // insert a single word to the trie tree
    public void insertWords(String word, TrieNode root){
        TrieNode cur = root;
        char[] wordChar = word.toCharArray();
        for(char c: wordChar){
            if(cur.children[c-'a'] ==null){
                cur.children[c- 'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    public static void main(String[] args) {
        CompoundWordFinder c = new CompoundWordFinder();

        ArrayList<String> test = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String data = sc.next();
            test.add(data);
        }
//        System.out.println(test);
         c.compoundWordFinder(test);



    }
}
