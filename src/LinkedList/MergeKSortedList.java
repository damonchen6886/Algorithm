package LinkedList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
    class ListNode{
        ListNode next;
        int value;
        public ListNode(int value){
            this.value = value;
        }
    }



    // divide conquer approach:  list.size = n  average length of node：m
    // time: O(n*m log(n));
    // space log(n);
    public ListNode mergeKList(List<ListNode> lists){
        if(lists.size() == 0){
            return null;
        }
        return merge(lists, 0, lists.size()-1);
    }
    // same divide and conquer function
    private ListNode merge(List<ListNode> lists, int left, int right){
        // base case
        if(left >= right){
            return lists.get(left);
        }
        // divide
        int mid = left + (right - left)/2;
        ListNode left1 = merge(lists, left, mid);
        ListNode right1 = merge(lists, mid+1, right);
        // conquer
        return merge(left1, right1);
    }
    // you only need to implement the custom merge function
    private ListNode merge(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(one != null && two != null){
            if(one.value < two.value){
                head.next = one;
                one = one.next;
                head = head.next;
            } else {
                head.next = two;
                two = two.next;
                head = head.next;
            }
        }
        if(one != null){
            head.next = one;
        } else {
            head.next = two;
        }
        return dummy.next;
    }
    /// recursive merge
    private ListNode merge2(ListNode a, ListNode b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        if(a.value > b.value){
            b.next = merge(a,b.next);
            return b;
        }
        else{
            a.next = merge(a.next,b);
            return a;
        }
    }

    // heap approach:  list.size = n  average length of node：m
    // time: O(n*m log(n));
    // space n

    public ListNode mergKHeap(List<ListNode> lists){
        if(lists == null || lists.size() == 0){
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), (a, b) -> a.value -b.value);
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null){
                pq.offer(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            head.next = cur;
            head = cur;
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }




}
