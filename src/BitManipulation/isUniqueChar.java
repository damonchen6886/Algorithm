package day36;

import java.util.HashSet;

public class isUniqueChar {

    //We are using ASCII charset, the value of valid characters are from 0 to 255
    //The given string is not null
    //Examples
    //
    //all the characters in "abA+\8" are unique
    //"abA+\a88" contains duplicate characters

    // bit solution
    public boolean isUnique(String s){
        // int[] visited = new int[256]; // O:256
        int[] visited = new int[8]; // int = 4 bytes = 32 bits, 8 ints = 32 bytes = 256 bits
        char[] array = s.toCharArray();
        for(char c:array){
            // for a value c in range of 0 - 256
            // it maps to the int at c/32 as index
            // it also maps the c%32 as the index of bits
            if(((visited[c/32] >>> (c%32)) & 1) != 0){
                // bit-tester of the k-th bits, k = c%32
                return false;
            }
            // bit-setter to 1 in the k-th bits
            visited[c/32] |= 1 << (c%32);
        }
        return true;
    }

    // regular solution
    public boolean isDuplicate(String s){
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }

}

