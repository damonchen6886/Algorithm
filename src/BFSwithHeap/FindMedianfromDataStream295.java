package BFSwithHeap;

import java.util.PriorityQueue;

public class FindMedianfromDataStream295 {

    //思路： 用两个heap 来存 左右两边的最大值 和最小值 每次加入新值的时候 判断 新值和左右顶部值的大小的 在加入到对应的heap里面
    // 用最大堆来存左边的数， 用最小堆来存右半边的数， 保证 中位数在 最大堆的堆顶或者最小堆的堆顶
    // 复杂度 O(Log(n))
    // 简洁版：
    class MedianFinder {

        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;


        /** initialize your data structure here. */
        public MedianFinder() {
            // max heap
            left = new PriorityQueue<>((a,b) -> b.compareTo(a));
            // min heap
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            left.add(num);
            right.add(left.poll());
            if(right.size() > left.size()){
                left.add(right.poll());
            }

        }


        public double findMedian() {
            int leftLength  = left.size();
            int rightLength = right.size();

            if((leftLength+rightLength)%2  == 0){
                return ((double)(left.peek()+right.peek()))/2;
            }

            return left.peek();

        }
    }


    //复杂版
    class MedianFinder2 {

        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;


        /** initialize your data structure here. */
        public MedianFinder2() {
            // max heap
            left = new PriorityQueue<>((a,b) ->  a== b? 0 : a>b? -1: 1);
            // min heap
            right = new PriorityQueue<>();
            left.offer(Integer.MIN_VALUE);
            right.offer(Integer.MAX_VALUE);
        }

        public void addNum(int num) {
            int leftLength  = left.size();
            int rightLength = right.size();

            if(leftLength <= rightLength){
                if(num <= left.peek()){
                    left.offer(num);
                }
                else if(num > left.peek()){
                    if(num <= right.peek()){
                        left.offer(num);
                    }
                    else if(num >right.peek()){
                        int val = right.poll();
                        left.offer(val);
                        right.offer(num);
                    }
                }
            }
            if(leftLength > rightLength){
                if(num >= right.peek()){
                    right.offer(num);
                }
                else if(num < right.peek()){
                    if(num >= left.peek()){
                        right.offer(num);
                    }
                    else if(num < left.peek()){
                        int val = left.poll();
                        right.offer(val);
                        left.offer(num);
                    }
                }
            }

        }


        public double findMedian() {
            int leftLength  = left.size();
            int rightLength = right.size();
            if(left.peek() == Integer.MIN_VALUE || right.peek() == Integer.MAX_VALUE){
                if(right.peek() == Integer.MAX_VALUE && left.peek() != Integer.MIN_VALUE){
                    return left.peek();
                }
                else if(right.peek() != Integer.MAX_VALUE-1 && left.peek() == Integer.MIN_VALUE){
                    right.peek();
                }
                else{
                    return 0;
                }
            }
            else if((leftLength+rightLength)%2  == 0){
                return ((double)(left.peek()+right.peek()))/2;
            }
            else if(leftLength > rightLength){
                return left.peek();
            }
            return right.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}
