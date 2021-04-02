package day34;

import day33.ReverseLinkedlist;

public class removeNthNode {
    ////

    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null || n < 0) return head;
        ListNode fast, slow;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        fast = head;
        slow = dummy;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    //////////////////////////////////////////////////

    public ListNode removeNthNode(ListNode node, int n){
        int length = getLength(node);
        if(length < n){
            return node;
        }
        int index = length -n;
        ListNode dummy = new ListNode(-1);
        dummy.next =node;
        ListNode head = node;
        for(int i = 0; i < index-1; i++){
            head = head.next;
        }
        if(head.next != null && head.next.next != null){
            head.next = head.next.next;
        }
        if(head.next.next == null){
            head.next = null;
        }
        return dummy.next;

    }
    private int getLength(ListNode n){
        int count =0;
        ListNode temp = n;
        while(n!= null){
            count++;
            temp = temp.next;
        }
        return count;

    }
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;

        }


    }

}
