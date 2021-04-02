package LinkedList;

public class findStartCycle {
    public ListNode detectCycle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            if(slow == fast){
                fast = head;
                break;

            }
            slow = slow.next;
            fast =fast.next.next;
        }
        if(fast == null || fast.next == null){
            return null;
        }
        while(fast != slow){

            slow = slow.next;
            fast = fast.next;

        }
        return slow;




    }    //
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;

        }
    }


}
