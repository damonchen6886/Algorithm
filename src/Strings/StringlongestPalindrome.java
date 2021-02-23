package Strings;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class StringlongestPalindrome {


    private char[] process(char[] string){

        if(string == null || string.length == 0){
            return string;
        }
        char[] newString = new char[string.length << 1 + 1];
        int index = 0;
        for(int i = 0; i < newString.length; i++){
            if(i % 2 == 0){
                newString[i] = string[index++];
            } else {
                newString[i] = '#';
            }
        }
        return newString;
    }
    //  my         id          mx
    //  |                      |
    // -------------------------
    // j                   i
    // 以下两种情况  要外扩
    // i > mx i == mx
    // i < mx && p[j] == mx-i
    // 其他情况 直接取
    public int Manacher(char[] string){
        char[] newString = process(string);
        int len = newString.length;
        int[] p = new int[len];
        int id = 0;
        int mx = 1;
        for(int i = 1; i < len; i++){
            if(mx > i){
                p[i] = Math.min(p[2*id-i], mx-i);
            } else {
                p[i] = 1;
            }
            while(newString[i + p[i]] == newString[i-p[i]]){
                p[i] ++;
            }
            if(mx < i + p[i]){
                mx = i + p[i];
                id = i;
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < newString.length; i++){
            res = Math.max(res, p[i] - 1);
        }
        return res;
    }

    //-------------------
    private String preprocessString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return sb.toString();
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String processedString = preprocessString(s);
        int[] p = new int[processedString.length()];
        int centralPoint = 0;
        int id;
        int mx = 0;
        for (int i = 0; i < processedString.length(); i++) {
            if (centralPoint + p[centralPoint] < i) {
                centralPoint = i;
            }
            id = Math.min(p[2 * centralPoint - i], centralPoint + p[centralPoint] - i);
            while (id <= i && i + id < processedString.length() && processedString.charAt(i - id) == processedString.charAt(i + id)) {
                id++;
            }
            p[i] = id - 1;
            if (p[i] > p[mx]) {
                mx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = mx - p[mx]; i <= mx + p[mx]; i++) {
            if (processedString.charAt(i) != '#') {
                sb.append(processedString.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int shortestDistanceStrings(String[] arr, String s1, String s2){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int pos1 = -1;
        for(int i = 0; i< arr.length;i++){
            if(arr[i].equals(s1) || arr[i].equals(s2)){



                if((pos1 != -1 && !arr[i].equals(arr[pos1]))){
                    result = Math.min(result, i -pos1);
                }
                pos1 = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
//        System.out.println(shortestDistanceStrings(words, "coding", "practice"));
        System.out.println(shortestDistanceStrings(words, "makes", "coding"));
    }


}
