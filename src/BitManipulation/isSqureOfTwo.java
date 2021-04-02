package BitManipulation;

public class isSqureOfTwo {

    //Determine if a given integer is power of 2.
    //
    //Examples
    //
    //16 is power of 2 (2 ^ 4)
    //3 is not
    //0 is not
    //-1 is not
    public boolean isPowerofTwo(int x){
        int count = 0;
        for(int  i = 0; i < 32; i++){
            int temp = x;
            if(((temp >> i) & 1) == 0){
                count++;
            }
        }
        return count == 1;
    }
    public boolean isPowerOfTwo(int x){
        if(x <= 0) return false;
        while((x & 1) == 0) x >>>= 1;
        return x == 1;
    }



    //Determine the number of bits that are different for two given integers.
    //
    //Examples
    //
    //5(“0101”) and 8(“1000”) has 3 different bits
    public int numberInteger(int a, int b){
        int dif = a ^ b;
        int count = 0;
        for(int  i = 0; i < 32; i++){
            if(((dif >>i) &1) == 0){
                count++;
            }
        }
        return count;
    }

    public int numberInteger2(int a, int b){
        int dif = a ^ b;
        int count = 0;
        while(dif != 0){
            count += dif &1;
            a >>>=1;
        }
        return count;
    }


}
