package BitManipulation;

public class bit {
    //Building Block
    //Given a number of x, test whether x's k-th bit is one (bit tester)

    public boolean bitTester(int x, int k){
        if(((x >> k ) & 1) == 0){  // move x to right k steps
            //  xxxxx   k xxxxxxx;
            //  00000   1 0000000
            return false;
        }
        else{
            return true;
        }

    }



    //Given a number of x, how to set x's k-th bit to 1(bit setter)
    public int setone(int x, int k){
        return x = x | (1<<k);

    }
    //Given a number of x, how to set x's k-th bit to 0(bit setter2)
    public int setTwo(int x, int k){
        int a = ~(1 << k);
        return x = x & a;

    }




    public static void main(String[] args) {
        int a = 0b101;   // 2进制  --> 0b
        int b = 0x101;  // 16进制  --> 0x
        int c = 011;    // 8 进制  --> 01
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        //位运算 五大运算：
        // 加  或   且   非  异或
        // +   ||   &   ~    ^

        // 逻辑右移 >>  删掉最右边 左边最大是什么就补什么  ex：1 0 1 1  --> 101  -> 1 101
        //                                                      -  --> -    -> 1 101
        // 算数右移 >>>  给左边无脑补0                  ex：1 0 1 1  --> 0 1 0 1

        // 逻辑左移 和算数左移 没区别  都给右边加0
        // 0 ^ 0 = 0;
        // x ^ x = 0;
        // 0 ^ x = x;

        //  a ^ b = c  -->  c ^ b = a  -->      c ^ a = b;
    }

    //Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
    //Example 1:
    //	Input:  [1,2,2,3,4,4,5,3]
    //	Output:  [1,5]
    //
    //Example 2:
    //	Input: [1,1,2,3,4,4]
    //	Output:  [2,3]


    // k * n + 1
    public int[] singleValue(int[] num){
        int xor = 0;
        for(int i : num){
            xor ^= i;
        }
        // get first different bits
        int dif = xor - (xor & (xor - 1));
        int groupZero = 0, groupOne = 0;
        for(int i : num){
            if((dif & i) == 0){
                groupZero ^= i;
            } else {
                groupOne ^= i;
            }
        }
        return new int[]{groupZero, groupOne};
    }


}
