package day42;

public class random5for7 {

    // choose a number with eual probability
    static class RandomFive{
        public static int random5(){
            return 0;
        }
    }

    public int random7(){
        while(true){
            int random = 5 * RandomFive.random5() + RandomFive.random5(); // (0-24) 4 = 1/25    5 * random5
            if(random < 21){
                return random % 7;
            }
        }
    }

    public int random1000(){
        while(true){
            int num = 0;
            for(int i = 0; i < 5; i++){
                num = num * 5 + RandomFive.random5();
            }
            if(num < 3000){
                return num % 3000;
            }
        }




    }

    public static void main(String[] args) {
       //double test = Math.random();
        int count0 = 0 ;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i = 0; i < 100000; i++){
            int test = (int)( Math.random()* 100);
            System.out.println(test);
            if(test == 0){
                count0++;
            }
            if(test == 1){
                count1++;
            }
            if(test == 2){
                count2++;
            }
            if(test == 3){
                count3++;
            }
        }
        //System.out.println(count1  +  count2);

        System.out.println("count0 = " + count0 );
        System.out.println("count1 = " + (count1) );
        System.out.println("count2 = " +(count2) );
        System.out.println("count3 = " + (count3) );
    }
}
