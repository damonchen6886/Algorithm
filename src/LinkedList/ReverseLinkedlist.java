package LinkedList;

public class ReverseLinkedlist {
    //
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;

        }

        //recursion

        public ListNode reverseRecursion(ListNode head){
            // base case
            if(head == null || head.next == null){
                return head;
            }
            // recursion rule
            ListNode node = reverseRecursion(head.next);
            head.next.next = head;
            // 在stack最顶上的时候 防止成环 所以把最顶上的指针指向null
            head.next = null;
            return node;
        }


        // iterative
        public ListNode reverseIterative(ListNode head){
            ListNode cur = head;
            ListNode prev = null;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }


        public ListNode reverseList(ListNode l){
            ListNode head = l;
            ListNode prev = null;
            while(head != null){
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;

        }
    }
}
