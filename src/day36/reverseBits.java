package day36;

public class reverseBits {
    //
    //# Reverse bits
    //"100101" -> "101001"
    //
    public int reverse(int num){
        for(int offset = 0; offset < 16; offset++){
            int right = (num >> offset) & 1;
            int left = (num >> (31-offset)) & 1;
            if(left != right){
                // 局部取反, ^1
                num ^= (1 << offset);
                num ^= (1 << (31-offset));
            }
        }
        return num;
    }

    public int reverse2(int s){
        int result = 0 ;
        for(int i =0; i < 32; i++){
            // if i-th index  != 0:
            if(((s >> i) &1) != 0){
                //set 32-i th index = 1;
                result = result | 1<<(32-i);
            }
            else{
                //set 32 - i th to 0
                result =  result & ~(1<<(32- i));
            }

        }
        return result;


    }




}
