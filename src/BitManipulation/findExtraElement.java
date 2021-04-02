package BitManipulation.day37;

public class findExtraElement {
    //Given k * n + 1 numbers, every numbers occurs twice except one, find it.
    //if k is even, k is odd
    //Input:  [1,1,2,3,3,3,2,2,4,1], k = 3
    //Output:  4

    // k * n + 1
    public int singleValue(int[] num){
        // Assumption: the given array is not null and not empty
        // 1 int = 32 bites = 4 bytes
        // bytes short boolean int double char long
        // 1 int = 4 bytes = 32 bits
        int[] bits = new int[32];
        int res = 0;
        // [,,,,,,,,,,,,,] 32
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < num.length; j++){
                bits[i] += (num[j] >> i & 1);
                bits[i] %= 3;
            }
            res |= (bits[i] << i);
        }
        return res;
    }
}
