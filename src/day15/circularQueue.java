package day15;

public class circularQueue {

    //Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
    //One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
    //
    //Your implementation should support following operations:
    //MyCircularQueue(k): Constructor, set the size of the queue to be k.
    //Front: Get the front item from the queue. If the queue is empty, return -1.
    //Rear: Get the last item from the queue. If the queue is empty, return -1.
    //enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
    //deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
    //isEmpty(): Checks whether the circular queue is empty or not.
    //isFull(): Checks whether the circular queue is full or not.
    //
    //Example:
    //MyCircularQueue circularQueue = new MycircularQueue(3); // set the size to be 3
    //circularQueue.enQueue(1);  // return true
    //circularQueue.enQueue(2);  // return true
    //circularQueue.enQueue(3);  // return true
    //circularQueue.enQueue(4);  // return false, the queue is full
    //circularQueue.Rear();  // return 3
    //circularQueue.isFull();  // return true
    //circularQueue.deQueue();  // return true
    //circularQueue.enQueue(4);  // return true
    //circularQueue.Rear();  // return 4
    // Queue : FIFO : pick and offer in different side : offer poll
    // Stack : LIFO  : pick and offer in the same side ： push pop
    // Deque : offerFirst, offerLast,  pollFirst, pollLast()
//     -----------------------------------
// ->   f     A   B                         l         <-C
//     ------------------------------------

    // Use two stacks to implement a queue
    // Use one queue to implement a stack
    int cap;
    int[] arr;
    int front;
    int back;
    public circularQueue(int cap){
        this.cap =cap;
        this.arr = new int[cap];
        this.front = -1;
        this.back = -1;
    }
    public boolean enQueue(int i){
        if(back +1 == front){
            return false;
        }
        arr[front] = i;
        front = (front +1) %cap;
        return true;

    }
    public boolean deQueue(int i){

        if(front+1 == back){
           return false;

        }
        back = (back+1)%cap;
        return false;



//         [4, 5, 3] <- array      [ , , , , , , , , , ,]
//                s                       ---------> e s ----->

//                e
//                             [, , , , , , , , , , ,]
//         [3,4 ,5 ] <- queue                s e

    }
    public int Front(){
        return arr[front];

    }
    public int Rear(){
        return arr[back];

    }
    public boolean isFull(){
        return back+1 == front;

    }
    public boolean isEmpty(){

        return front+1 == back;
    }


    static class circularQueue2 {

        private int[] data;
        private int head;
        private int tail;
        private int size;

        // initialize constructor
        public circularQueue2(int k){
            data = new int[k];
            head = -1;
            tail = -1; // small trick for starting
            size = k;
        }

        public boolean enQueue(int value){
            if(isFull()){
                return false;
            }
            if(isEmpty()){
                head = 0;
            }
            tail = (tail + 1)%size;
            data[tail] = value;
            return true;
        }

        public boolean dequeue(){
            if(isEmpty()){
                return false;
            }
            if(head == tail){
                // 只剩下1个元素， 抽取完之后就重置为-1
                head = -1;
                tail = -1;
                return true;
            }
            // 否则有多个元素
            head = (head + 1)%size;
            return true;
        }

        public int Font(){
            if(isEmpty()){
                return -1;
            }
            return data[head];
        }

        public int Rear(){
            if(isEmpty()){
                return -1;
            }
            return data[tail];
        }

        public boolean isEmpty(){
            return head == -1;
        }

        public boolean isFull(){
            return ((tail + 1)%size) == head;
        }

    }


    }
