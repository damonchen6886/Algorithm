package Notes;

public class ConsecutiveNumbersSum829 {

    //纯数学题： N 可以分解成 k +k+1 + k+2 + k+3 .... k+(i-1); 有多少个满足条件的k就是我们要的答案
    // 表达式： N = k* i  + [0+(i-1)*i/2]
    // 移项： N - (i-1) *i/2 = k-i
    // (i-1) *i/2  是循环中 i 满足的条件
    // k 是我们需要取的值
    public int consecutiveNumbersSum(int n) {
        int result =0;
        for(int i = 1; i*(i-1)/2 < n;i++){
            if((n-i*(i-1)/2)%i ==0){
                result++;
            }
        }
        return result;


    }
}
