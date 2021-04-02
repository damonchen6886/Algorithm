package day30;

public class palindromeLinkedList {

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next =next;
        }
        public ListNode(int val){
            this.val =val;
        }
    }
    // check if a linkedlist is a palindrome
    // divide and conquer
    public boolean  sort(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null || fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode tail = reverse(temp);
        while(head != null && tail!= null){
            if(head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
    private ListNode reverse(ListNode slow){
        ListNode prev = null;
        while(slow!= null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        return prev;
    }


    //  abcdef 2 -> efabcd
    public char[] reOrder(char[] s, int n){
        int size = s.length;
        n = n%size;
        if(n ==0){
            return s;
        }
        swap(s,0, s.length-1);
        swap(s,0, n-1);
        swap(s,n, s.length-1);

        return s;

    }
    private void swap(char[] s,int start, int end){
        for(int i = start; i <= ((start+end)/2);i++){
            char temp = s[i];
            s[i] =  s[end+start-i];
            s[end+start-i] = temp;
        }
    }


    //Write a function to find the longest common prefix string amongst an array of strings.
    //If there is no common prefix, return an empty string"".
    //Example 1:
    //Input:
    //["flower","flow","flight"]
    //
    //Output:
    // "fl"
    //Example 2:
    //Input:
    //["dog","racecar","car"]
    //
    //Output:
    // ""
    public boolean commonPrefix(String word, String abbr) {
        int num = 0;
        int index= 0;
        for(int i = 0; i<abbr.length();i++){
            char c = abbr.charAt(i);
            if(c == '0' && num==0){
                return false;
            }
            if('0'<= c && c<='9'){
                num=num*10+c-'0';
            }
            else{
                index+=num;
                if(index >= word.length() ||word.charAt(index) != c){
                    return false;
                }
                num= 0;
                index++;
            }
        }
        return index + num == word.length();
    }

    public static void main(String[] args) {
        char[] s = new char[]{'a','b','c','d','e','f'};
        char[] a = new char[]{'i','n','t','e','r','n','a','t','i','o','n','a','l','i','z','a','t','i','o','n'};
        char [] abb = new char[]{'i','1','2','i','z','4','n'};
        char[] c = new char[]{'a','p','p','l','e'};
        char[] cabb = new char[]{'a','2','e'};
        char[] d = new char[]{'a'};
        char[] e = new char[]{'2'};
        palindromeLinkedList p = new palindromeLinkedList();
//        p.reOrder(s,2);
//        System.out.println(p.reOrder(s,2));
//        System.out.println(p.commonPrefix(a, abb));
//        System.out.println(p.commonPrefix(c, cabb));
//        System.out.println(p.commonPrefix(d, e));
    }

}
