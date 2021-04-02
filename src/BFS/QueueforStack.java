package _5BFS.day15;

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
        return queue.remove();

    }

    // top
    public int top(){
       return queue.peek();

    }


    // isEmpty
    public boolean isEmpty(){
        return queue.isEmpty();

    }
}
