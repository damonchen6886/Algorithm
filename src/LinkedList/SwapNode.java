package LinkedList;

public class SwapNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            if(head == null){
                return null;
            }
            if(head.next ==null){
                return head;
            }

            ListNode dummy = new ListNode(0);
            ListNode cur = head;
            dummy.next = head;
            ListNode firstNodePrev = dummy;
            firstNodePrev.next = head;
            int count =1;
            ListNode firstNode = head;
            while(count != k){
                cur = cur.next;
                firstNode = firstNode.next;
                firstNodePrev = firstNodePrev.next;
                count++;
            }
            System.out.println(firstNodePrev.val);
            System.out.println(firstNode.val);

            ListNode secondNode = head;
            ListNode secondNodePrev = dummy;
            secondNodePrev.next = secondNode;
            int next = 0;
            while(cur.next != null){
                cur = cur.next;
                secondNode = secondNode.next;
                secondNodePrev = secondNodePrev.next;
                next++;
            }
            System.out.println(secondNodePrev.val);
            System.out.println(secondNode.val);
            // System.out.println("count = " + count);
            // System.out.println("next = " + next);
            if(firstNode.next == null){
                ListNode temp = dummy.next.next;
                firstNodePrev.next  =head;
                head.next = null;
                dummy.next = firstNode;
                firstNode.next =temp;
                return dummy.next;

            }
            if(firstNodePrev == secondNode){
                secondNodePrev.next = firstNode;
                ListNode temp = firstNode.next;
                firstNode.next = secondNode;
                secondNode.next  = temp;
                return dummy.next;
            }

            if(secondNodePrev == firstNode || firstNode.next == secondNode){
                ListNode temp = secondNode.next;
                firstNodePrev.next = secondNode;
                secondNode.next = firstNode;
                firstNode.next  = temp;
                return dummy.next;
            }
            ListNode temp = secondNode.next;
            firstNodePrev.next = secondNode;
            secondNode.next = firstNode.next;
            secondNodePrev.next = firstNode;
            firstNode.next = temp;
            return dummy.next;



        }
    }


    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
}
