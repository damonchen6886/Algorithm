package DailyQuestions;

public class test {

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while(cur.next != null){
            ListNode slow = prev, fast = cur.next;
            head = appendHead(head,slow, fast);
            System.out.println(cur.val);
            cur = cur.next;
            prev= prev.next;
        }
        head = appendHead(head,cur, prev);
        return head;

//         ListNode dummy  = new ListNode(0);
//         dummy.next = head;
//         ListNode result = head;
//         while(dummy.next != null){
//             ListNode  prev = dummy;
//             ListNode before = dummy;

//             ListNode cur = dummy.next;
//             ListNode curNext = cur.next;
//             before.next = curNext;
//             while(true){
//                 if(cur.val > curNext.val){
//                     curNext = curNext.next;
//                     prev = prev.next;
//                     continue;
//                 }
//                 else{
//                     prev.next = cur;
//                     cur.next = curNext;
//                     break;
//                 }
//             }
    }
    private static ListNode appendHead(ListNode head, ListNode cur, ListNode prev){
        prev.next = cur.next;
        if(head.val > cur.val){
            cur.next = head;
            return head;
        }
        ListNode fit = head;
        while(fit.next != null){
            if(cur.val > fit.next.val){
                fit = fit.next;
            } else {
                break;
            }
        }
        ListNode next = fit.next;
        fit.next = cur;
        cur.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(-1);
        ListNode two = new ListNode(5);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(0);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode listNode = insertionSortList(one);
        while(listNode.next != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }



}

class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }
}
