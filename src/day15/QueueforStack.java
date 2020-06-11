package day15;

import java.util.LinkedList;
import java.util.Queue;

public class QueueforStack {

    private Queue<Integer> queue;
    public QueueforStack(){
        this.queue = new LinkedList<Integer>();
    }

    // push
    public void push(int a){
        queue.add(a);
        for(int i = 0; i < queue.size()-1;i++){
            queue.add(queue.poll());
        }

    }

    // pop
    public int pop(){
        int size = queue.size();
        for(int i = 0; i < size-1; i++){
            int temp = queue.poll();
            queue.offer(temp);

        }
        return queue.poll();

    }

    // top
    public int top(){
        int size = queue.size();
        int temp;
        for(int i = 0; i < size-1; i++){
            temp = queue.poll();
            queue.offer(temp);

        }
        int result = queue.peek();
        temp = queue.poll();
        queue.offer(temp);
        return result;

    }


    // isEmpty
    public boolean isEmpty(){
        return queue.isEmpty();

    }
}
