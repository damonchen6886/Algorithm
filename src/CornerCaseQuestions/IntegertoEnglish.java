package CornerCaseQuestions;

public class IntegertoEnglish {
    // leetcode 273
    String[] twenty = {"","One", "Two", "Three","Four","Five","Six","Seven","Eight",
            "Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
            "Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] thousand = {"","Thousand", "Million","Billion"};
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        int index =0;
        if(num ==0){
            return "Zero";
        }
        String word  ="";
        while(num >0){
            if(num%1000 !=0){
                word = dfs(num%1000) + thousand[index] + " "+ word;
            }
            num/= 1000;
            index++;
        }
        return word.trim();
    }
    private String dfs(int num){
        if(num ==0){
            return "";
        }
        if(num <20){
            return twenty[num]+ " ";
        }
        if(num <100){
            return tens[num/10] + " "+ dfs(num%10);
        }
        else{
            return twenty[num/100] + " Hundred " + dfs(num%100);
        }
    }
}
