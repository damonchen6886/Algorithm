package LinkedList;

public class ReverseFromAtoB {

    //Reverse a linked list from position m _to _n. Do it in one-pass.
    //Note: 1 ≤m≤n≤ length of list.
    //Example:
    //Input: 1->2->3->4->5->NULL, m = 2, n = 4
    //Output: 1->4->3->2->5->NULL
    public ListNode reverseII(ListNode head, int m, int n){
        // corner case
        if(head == null || head.next == null || m >= n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for(int i = 1; i < m; i++){
            // the length of linkedlist is short
            if(head == null){
                return dummy.next;
            }
            head = head.next;
        }
        // start to reverse
        // prev.n
        ListNode prev = head; // one step ahead starting node
        ListNode tail = head.next;
        ListNode cur = head.next;
        prev.next = null;
        for(int i = m; i <= n; i++){
            if(i == n){
                tail.next = cur.next;
            }
            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }


    // not working

    public ListNode reverseFromMN(ListNode head, int m, int n){
        int count = 0;

        ListNode cur = head;
        ListNode prev = null;

        ListNode start = head;
        ListNode temp = head;
        ListNode end = null;

        while(cur!= null){

            if(count < m-1){
                cur = cur.next;
                start = start.next;

            }
            else if(count == m-1){
                cur = cur.next;
                end = cur;

            }
            else if(count > n){
                start.next =cur;
                end.next = temp;
                break;
            }
            // reverse
            else{
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur =next;
            }
            count++;
            temp = temp.next;

        }
        return head;


    }



    //
    class ListNode{
        int val;
        ListNode next; //
        public ListNode(int val){
            this.val = val;

        }
    }


}
