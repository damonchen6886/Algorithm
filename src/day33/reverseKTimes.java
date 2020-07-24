package day33;

public class reverseKTimes {
    //Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    //If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    //You may not alter the values in the nodes, only nodes itself may be changed.
    //Only constant memory is allowed.
    //For example,
    //Given this linked list: 1->2->3->4->5
    //For k = 2, you should return: 2->1->4->3->5
    //For k = 3, you should return: 3->2->1-


    //
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = dummy.next;
        int pos = 1;
        while(cur != null){
            if(pos == k){
                pos = 0;
                prev = reverse(prev, cur);
                cur = prev.next;
            } else {
                cur = cur.next;
            }
            pos++;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode prev, ListNode end){
        if(prev == null || end == null) return null;
        ListNode cur = prev.next;
        while(prev.next != end){
            ListNode nt = cur.next.next;
            cur.next.next = prev.next;
            prev.next = cur.next;
            cur.next = nt;
        }
        return cur;
    }
    ///////////////////////////////////////////

    public ListNode reverse3(ListNode head, int k){

        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        ListNode dummy2 = new ListNode(0);
        dummy2.next =head;
        ListNode prev = dummy2;
        ListNode tail = dummy2;
        ListNode cur = dummy2;
        prev.next = null;
        int count = 1;
        while(head != null){
            if(count == k){
                tail.next =cur.next;
                prev.next =tail.next;
                count = 0;
                length--;
                cur = tail.next;
                continue;
            }
            // remaining less than k
            if(length < k){
                tail.next =cur.next;
                break;
            }
            ListNode next =cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
            count++;
            length--;
            head = head.next;


        }
        return dummy.next;

    }
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;

        }
    }
}
