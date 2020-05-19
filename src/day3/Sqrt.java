package day3;

public class Sqrt {

    // 2.1
//     Implement double sqrt(double x) and x >= 0.
// * 	Compute and return the square root of x.
// * Example:
// * 	Given n = 2 return 1.41421356

    public double sqrt(double x){
        double left = 0.0;
        double right= x;
        if(x  == 1){
            return 1;
        }
            double mid = 0 ;

            while(true){
                mid = left +(right-left)/2;
                if(mid * mid - x <= 0.001){
                    break;
                }
                if(mid * mid > x){
                    right  = mid;
                }
                else{
                    left = mid;
                }
            }
            return mid;

    }



}
