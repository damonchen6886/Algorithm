package lineSweep;

import java.util.ArrayList;
import java.util.TreeMap;

public class myCalendar {
    //Implement aMyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
    //Your class will have the method,book(int start, int end). Formally, this represents a booking on the half open interval[start, end), the range of real numbersxsuch thatstart <= x < end.
    //A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
    //For each call to the methodMyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
    //Your class will be called like this:
    //MyCalendar cal = new MyCalendar();
    //MyCalendar.book(start, end)
    //Example 1:
    //MyCalendar();
    //MyCalendar.book(10, 20); // returns true
    //MyCalendar.book(15, 25); // returns false
    //MyCalendar.book(20, 30); // returns true
    //
    //Explanation:
    //
    //The first event can be booked.  The second can't because time 15 is already booked by another event.
    //The third event can be booked, as the first event takes every time less than 20, but not including 20.
    //Note:
    //The number of calls to MyCalendar.book
    //per test case will be at most 1000.
    //In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9]

    ArrayList<point> books = new ArrayList<>();
    public boolean book(int curStart, int curEnd){

        //  cur ->
        //  1.cur.start < p.end && cur.end > p.start
        //  1.1 cur.start < p.start && cur.end > p.start
        //  1.2 cur.start > p.start && cur.start < p.end
        //  2.cur.start > p.end continue
        for(point p: books){
            if(curStart < p.end && curStart > p.start){
                return false;
            }
            if(curEnd < p.end && curEnd > p.start){
                return false;
            }
            if(curStart < p.start && curEnd > p.end){
                return false;
            }

        }
        point p = new point(curStart, curEnd);
        books.add(p);
        return true;

    }

    class point{
        int start;
        int end;

        public point(int start, int end){
            this.start = start;
            this.end = end;
        }

    }


    //-----------------------
    // method 2  O(logN);
    // Sweep line
    TreeMap<Integer, Integer> calender = new TreeMap<>();;
    // insert logn
    // delete logn, find logn
    // construct n


    // O(logn) Space: O(n), the number of events you insert
    public boolean book2(int start, int end){
        Integer prev = calender.floorKey(start);
        Integer next = calender.ceilingKey(start);
        if((prev == null) || start >= calender.get(prev) && (next == null) || end <= next){
            calender.put(start, end);
            return true;
        }
        return false;

    }

}
