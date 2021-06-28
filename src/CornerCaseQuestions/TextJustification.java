package CornerCaseQuestions;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    // 68
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();
        while(left < words.length){
            int right = findRight(words, maxWidth, left);
            result.add(justify(left, right, words,maxWidth));
            left =right+1;
        }
        return result;
    }

    private int findRight(String[] words,int maxWidth, int left){
        int right = left;
        // next word length
        int sum = words[right++].length();
        // provent right++ out of bound
        while(right< words.length && (sum+1 + words[right].length() <= maxWidth)){
            sum+= 1+ words[right++].length();
        }
        return right-1;
    }

    private String justify(int left, int right, String[] words, int maxWidth){
        if(right - left ==0){
            return padResult(words[left], maxWidth);
        }
        boolean isLastLine =  right == words.length -1;
        // how many breaks need to be create bewteen words each line "a  b  c" in this case will be 2
        int numSpace = right-left;
        int totalSpace = maxWidth - checkLength(left, right, words);

        // num sapce for each word
        String space = isLastLine ?  " " : blank(totalSpace/numSpace);
        int remainder = isLastLine ? 0 : totalSpace%numSpace;
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right;i++){
            sb.append(words[i]);
            sb.append(space);
            sb.append(remainder-- > 0?  " ": "");
        }
        return padResult(sb.toString().trim(), maxWidth);

    }
    private String blank(int count){
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < count; i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    private int checkLength(int left, int right, String[] words){
        int length = 0;
        for(int i = left; i <= right;i++){
            length+= words[i].length();
        }
        return length;
    }
    private String padResult(String result, int maxWidth){
        return result+= blank(maxWidth - result.length());
    }

}
