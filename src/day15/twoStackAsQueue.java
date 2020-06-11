package day15;

import java.util.Deque;
import java.util.LinkedList;

public class twoStackAsQueue<T> {
    // Queue : FIFO : pick and offer in different side : offer poll
    // Stack : LIFO  : pick and offer in the same side ： push pop
    // Deque : offerFirst, offerLast,  pollFirst, pollLast()
//     -----------------------------------
// ->   f     A   B                         l         <-C
//     ------------------------------------

    // Use two stacks to implement a queue

    public Deque<T> stack1;
    private Deque<T> stack2;
    public twoStackAsQueue(){
        stack1 = new LinkedList<>();
         stack2 = new LinkedList<>();
    }
    // construtor

    public void switch1(Deque<T> stack1, Deque<T> stack2){

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return;

    }

    // offer
    public void offer(T i){
        stack1.push(i);


    }

    // poll
    public T poll(){
        if(!stack2.isEmpty()){
            return  stack2.pop();

        }
        switch1(stack1, stack2);
        return stack2.pop();


    }

    // top -> peek()

    public T peek(){
        if(!stack2.isEmpty()){
            return  stack2.peek();

        }
        switch1(stack1, stack2);
        return stack2.peek();


    }

}
