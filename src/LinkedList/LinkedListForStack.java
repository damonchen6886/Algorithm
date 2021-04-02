package LinkedList;

public class LinkedListForStack {
    //Write an algorithm to implement Stack using Linked List.
    //If you do not know about then for starters its abstract data type in which follows the principle of LIFO (Last-In-First-Out) which means the data goes in last comes out first to read about in detail please read this link Stack
    //Approach:
    //Solution is quite simple, Earlier we have seen an article “Linked List Implementation“, we need to make some changes to make it work as Stack.
    // linkedlist
    private class ListNode{
        int val;
        ListNode next;
        private ListNode(int val){
            this.val = val;
        }
    }
    ListNode head;


    public LinkedListForStack(){
        this.head = null;

    }

    public void push(ListNode cur){
        cur.next = head;
        head =cur;

    }

    public boolean isEmpty(){
        return head == null;
    }

    public int peek(){
        if(isEmpty()){

            return -1;
        }
        return head.val;

    }

    public void pop(){
        if(head == null){
            return;

        }
        head = head.next;
    }


}
