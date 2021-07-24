package OA.Tubular;

import java.util.Arrays;
import java.util.HashMap;

public class Factorial {
    int[] factorialTable;
    int index;
    public Factorial(int n){
        factorialTable = new int[n+1];
        factorialTable[1] =1;
        index =1;
    }

    // O(k+MAX_N)
    // assuming input < MAX_N
    public int callFactorial(int k){
        if(factorialTable[k] != 0){
            return factorialTable[k];
        }
        int delta = k -index;
        while(delta>0){
            int r = factorialTable[index]*(++index);
            factorialTable[index] = r;
            delta--;
        }
        return factorialTable[index];
    }



    // standard factorial
    public static int factorial( int n ) {
        int result = 1;
        while(n >=1){
            result*= n;
            n--;
        }
        return result;
    }
    HashMap<String, Integer> h  =new HashMap<>();
    // only use +
    public static int factorial2(int n){
        int result = 1, sum = 0, index =2;
        while(index <= n){
            sum = 0;
            for(int i = 0; i < index; i ++){
                sum += result;
            }
            index ++;
            result = sum;
        }
        return result;
    }



    public static void main(String[] args) {
        Factorial f = new Factorial(10);
        System.out.println(factorial(10));
        System.out.println(factorial(10));
        System.out.println(f.callFactorial(4));
        System.out.println(Arrays.toString(f.factorialTable));
        System.out.println(f.callFactorial(6));
        System.out.println(Arrays.toString(f.factorialTable));
        System.out.println(f.callFactorial(10));
        System.out.println(Arrays.toString(f.factorialTable));
    }

}
