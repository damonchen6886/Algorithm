package day40;

import java.util.TreeMap;

public class CalendarFollowup {

    // Sweep line
    // key: start time , value: how many same start time
    // insert logn
    // delete logn, find logn
    // construct n
    public class myCalender{
        TreeMap<Integer,Integer> calender;
        public myCalender(){
            calender = new TreeMap<>();
        }

        // O(logn) Space: O(n), the number of events you insert
        public boolean book(int start, int end){
            calender.put(start, calender.getOrDefault(start, 0) + 1);
            calender.put(end, calender.getOrDefault(end, 0) - 1);
            int concurrent = 0;
            // TreeMap: API .values();
            for(int v: calender.values()){
                concurrent += v;
                if(concurrent >= 3){
                    calender.put(start, calender.get(start) - 1);
                    calender.put(end, calender.get(end) + 1);

                    if(calender.get(start) == 0){
                        calender.remove(start);
                    }

                    if(calender.get(end) == 0){
                        calender.remove(end);
                    }
                    return false;
                }
            }
            return true;
        }


    }


    ///--------------------------------------------------------
    TreeMap<Integer,Integer> calender;
    TreeMap<Integer, Integer> overlaps;
    // O(logn) Space: O(n), the number of events you insert


    public CalendarFollowup(){
    calender = new TreeMap<>();
    overlaps = new TreeMap<>();}


    public boolean book1(int start, int end){
        Integer left = calender.floorKey(start);
        Integer right = calender.ceilingKey(start);
        Integer overlapsLeft = overlaps.floorKey(start);
        Integer overlapsRight = overlaps.ceilingKey(start);

        if((left == null) || start >= calender.get(left) && (right == null) || end <= right){

            calender.put(start,end);
            return true;
        }
        else if((overlapsLeft == null) || start >= overlaps.get(overlapsLeft) && (overlapsRight == null) || end <= overlapsRight){
            if(start > left && start < calender.get(left)){
                if(end >  calender.get(left)){
                    overlaps.put(start, calender.get(left));
                }
                if(end < calender.get(left)){
                    overlaps.put(start, end);
                }

            }
            if(start < left && end > left){
                if(end < right){
                    overlaps.put(left, start);
                }
                if(end > right){
                    overlaps.put(left, right);
                }

            }

            return true;
        }

        return false;


    }
}



