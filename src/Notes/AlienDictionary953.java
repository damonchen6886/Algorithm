package Notes;

import java.util.HashMap;

public class AlienDictionary953 {
    //In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
    //
    //Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
    //Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    //Output: false
    //Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

    // 思路： 先把order HashMap里面  然后比较两个单词 每个char在HashMap里面的value（位置）
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length();i++){
            map.put(order.charAt(i),i);
        }
        String word = words[0];
        for(int i =1;i < words.length;i++){
            String cur = words[i];
            for(int j = 0; j < word.length();j++){

                if( j < cur.length() && map.get(word.charAt(j)) > map.get(cur.charAt(j))){
                    return false;
                }
                else if( j < cur.length() &&map.get(word.charAt(j)) < map.get(cur.charAt(j))){
                    break;
                }
                if(j > cur.length()-1){
                    return false;
                }

            }
            word = cur;
        }
        return true;
    }
}
