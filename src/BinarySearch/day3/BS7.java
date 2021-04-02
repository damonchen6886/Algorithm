package _1BinarySearch.day3;

//1.6 Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.
//        Assumptions
//        dictionary A is not null
//        dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds
//        Examples
//        A = {1, 2, 5, 9, ......}, T = 5, return 2
//        A = {1, 2, 5, 9, 12, ......}, T = 7, return -1


import java.util.ArrayList;

public class BS7 {
    public int search(ArrayList<Integer> dictionary, int target) {
        int right = 0;
        while (dictionary.get(right) != null && dictionary.get(right) <= target) {
            right = right * 2;
        }

        int left = right / 2;
        while (right >= left) {

            int mid = left + (right - left) / 2;
            if (dictionary.get(mid) == null) {
                right = mid - 1;
            } else if (dictionary.get(mid) == target) {
                return mid;
            } else if (dictionary.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }
}
//// if xx.get(i) == null,
//(1,2,5, 6, 8 ,10,11) target = 10
//// step 1: find the range
//        1 2, 6, null
//        1 2  4   8


// disscusion: why jump 10 times more each move
//       Jump out         Jump in  (Assume you jump n times)
// 10 times         log_10(n)    +    log_2(10n)
// 2 times          log_2(n)     +     log_2(2n)
// difference = log_10(n) - log_2(n) + log_2(10n) - log_2(2n)
//            = log_10(n) - log_2(n / 10n * 2n) = log_10(n) - log_2(n/5) > 0  ==>  10 time is better
//                                                                           else: 2 times is better


