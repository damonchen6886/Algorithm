package Trie;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// insert all these words to the prefix tree
// [asd, asde, cesa, asdrts]
//Question
//Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
//        Example
//Given matrix:
//doaf
//agai
//dcan
//and dictionary:
//// n: average length of each word, m: number of words
//// matrix's size : a * b, Assume the longest length of all words = c
//// build graph: O(nm);
//// Dfs: O(a*b* min(c, a*b));
//// O(4^c)
//        `{"dog", "dad", "dgdg", "can", "again"}``
//        return {"dog", "dad", "can", "again"}


public class Trie{
    public TrieNode root;

    static class TrieNode{
        HashMap<Character, TrieNode> children;
        char c;
        boolean isWord;
        String s;

        // default constructor for root
        public TrieNode(){
            this.children = new HashMap<>();
            this.s = "";
        }

        // middle node
        public TrieNode(char c){
            this.c = c;
            this.s = "";
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }


    public Trie(){
        root = new TrieNode(); // root
    }

    public void insert(String word){
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode cur;
            if(children.containsKey(c)){
                cur = children.get(c);
            } else {
                cur = new TrieNode(c);
                children.put(c, cur);
            }
            children = cur.children;
            if(i == word.length() - 1){
                cur.isWord = true;
                cur.s = word;
            }
        }
    }

    public TrieNode searchTrieNode(String word){
        HashMap<Character, TrieNode> children = new HashMap<>();
        TrieNode cur = null;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                cur = children.get(c);
                children = cur.children;
            }
        }
        return cur;
    }

    public boolean search(String word){
        TrieNode cur = searchTrieNode(word);
        if(cur != null && cur.isWord){
            return true;
        }
        return false;
    }

    public class Solution{

        int[] dirX = {0,0,1,-1};
        int[] dirY = {-1,1,0,0};

        public List<String> wordSearchII(char[][] board, ArrayList<String> wordDict){
            List<String> res = new ArrayList<>();
            Trie trie = new Trie();
            for(String word:wordDict){
                trie.insert(word);
            }
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    dfs(board, i, j, res, trie.root);
                }
            }
            return res;
        }

        public void dfs(char[][] board, int i, int j, List<String> res, TrieNode root){
            // base case
            if(root.isWord){
                // api, contains -> O(n);
                if(!res.contains(root.s)){
                    res.add(root.s);
                }
            }
            // recursion rule
            if(isValid(i, j, board) && board[i][j] != '#' && root != null){
                if(root.children.containsKey(board[i][j])){
                    for(int k = 0; k < 4; k++){
                        int nextX = i + dirX[k];
                        int nextY = j + dirY[k];
                        char temp = board[i][j];
                        board[i][j] = '#';
                        dfs(board, nextX, nextY, res, root.children.get(temp));
                        board[i][j] = temp;
                    }
                }
            }
        }

        private boolean isValid(int i, int j, char[][] board){
            return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
        }
    }
}








