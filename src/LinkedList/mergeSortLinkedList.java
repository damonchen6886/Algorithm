package LinkedList;

public class mergeSortLinkedList {
    public  ListNode mregeSortLinkedList(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode mid = findMid(head);
        ListNode left = mregeSortLinkedList(head);
        ListNode right= mregeSortLinkedList(mid);
//        mid.next = null;
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-100);
        ListNode cur = dummy;
        while(left!= null && right!= null){
            if(left.value <= right.value){
                cur.next = left;
                left = left.next;
            }
            else{
                cur.next =right;
                right = right.next;
            }
             cur= cur.next;
        }
        if(left != null){
            cur.next = left;
        }
        else{
            cur.next = right;
        }
        return dummy.next;
    }

    private ListNode findMid(ListNode head){
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }

    class ListNode{
        ListNode next;
        int value;
        public ListNode(int value){
            this.value = value;
        }
    }

}
