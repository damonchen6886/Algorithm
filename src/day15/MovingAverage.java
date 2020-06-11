package day15;

import java.util.Deque;
import java.util.LinkedList;

//Follow1: Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//Example:
//MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
//
//m.next(6);
//m = new MovingAverage(5);
//
//
public class MovingAverage {

        Deque<Integer> queue;
         int sum = 0;
         int capacity;
    public MovingAverage(int capacity){
            this.capacity = capacity;
            this.sum = 0;

            this.queue = new LinkedList<>();
        }

        public double next(int value){
            queue.offer(value);
            sum +=value;
            if(queue.size() > capacity){

                sum-= queue.poll();
            }


            return sum/queue.size();


        }





}
