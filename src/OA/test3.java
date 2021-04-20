package OA;

import java.util.*;
import java.lang.*;
class test3{

    public static void main(String[] args) {
        String s = "b0.25";
        System.out.print(currencyR(s)+ "\n");
        System.out.print("a450 = "+ currencyR("a450")+ "\n");
        System.out.print("-c23 = "+ currencyR("-c23")+ "\n");
        System.out.print("(b2400) = "+ currencyR("(b2400)")+ "\n");
        System.out.print("a4,500.00 = "+ currencyR("a4,500.00")+ "\n");
        System.out.print("c0.25 = "+ currencyR("c0.25")+ "\n");
        System.out.print("********************"+ "\n");

        System.out.print("cat = "+ currencyR("cat")+ "\n");
        System.out.print("d25 = "+ currencyR("d25")+ "\n");
        System.out.print("a45,0 = "+ currencyR("a45,0")+ "\n");
        System.out.print("(c45,0) = "+ currencyR("(c45,0)")+ "\n");
        System.out.print("(-$3.50) = "+ currencyR("(-$3.50)")+ "\n");
        System.out.print("b120.00 = "+ currencyR("b120.00")+ "\n");
        System.out.print("a-50 = "+ currencyR("a-50")+ "\n");
        System.out.print(" c43.25 = "+ currencyR(" c43.25")+ "\n");
        System.out.print("a65. = "+ currencyR("a65.")+ "\n");
        System.out.print("c82.1 = "+ currencyR("c82.1")+ "\n");
        System.out.print("48.50 = "+ currencyR("48.50")+ "\n");
        System.out.print("b1200,000 = "+ currencyR("b1200,000")+ "\n");
    }
    public static boolean currencyR(String s){
        // base case check
        if(s == null || s.length() != s.trim().length() || s.length() == 0){
            return false;
        }
        char dollar = 'a';
        char yen = 'b';
        char euros = 'c';
        boolean hasParentheses = false;
        boolean allowedCents = false;
        boolean hasThousandSeparator = false;
        boolean isNegative = false;
        boolean hasCents = false;
        char currency = ' ';
        int intStartIndex = 1;
        int centIndex = -1;
        boolean existCent = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            char cur = s.charAt(i);
            if(i ==0  && (cur == '(' || cur== '-')){
                if(cur == '('){
                    hasParentheses =true;
                }
                else{
                    isNegative = true;
                }
                intStartIndex = 2;
                continue;
            }
            if((i ==0 || (i ==1 && (hasParentheses|| isNegative))) && cur == dollar || cur == euros || cur == yen){
                currency = cur;
                if(currency == dollar || currency == euros){
                    allowedCents = true;
                }
                continue;
            }
            if(cur == ','){
                hasThousandSeparator = true;
                sb.append(cur);
                continue;
            }
            if(allowedCents && cur == '.' && !existCent){
                hasCents = true;
                centIndex = i;
                existCent =true;
                sb.append(cur);
               continue;
            }
            if(cur < '0' || cur>'9') {
                if (hasParentheses && i == s.length() - 1 && cur == ')') {
                    continue;
                }
                return false;
            }
            sb.append(cur);
        }
//        System.out.println("money = "+ sb.toString());
        String trimmedAmount = sb.toString();
        // check thousand separator:
        if(hasThousandSeparator){
            if(hasCents) {
                trimmedAmount = s.substring(intStartIndex, s.indexOf('.'));
            }
            for(int i = trimmedAmount.length()-1; i > 0;i--){

                if(i%3 ==0  && trimmedAmount.charAt(i) != ',' || (i%3 != 0 && trimmedAmount.charAt(i) == ',')){
                    return false;
                }
            }
        }
        // check leading zeros:
        if(trimmedAmount.charAt(0) =='0'){
            if(!hasCents && trimmedAmount.length() != 1){
                return false;
            }
            if(hasCents && trimmedAmount.length()-centIndex-1 !=1){
                return false;
            }
        }
        // check cents
        if(centIndex != -1){
            if(!hasParentheses && centIndex+2+1 != s.length()){
                return  false;
            }
            if(hasParentheses && centIndex+3+1 != s.length()){
                return false;
            }
        }
        return true;
    }






}