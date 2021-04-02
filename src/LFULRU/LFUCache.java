package LFULRU;

import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V>{

    static class Node<K, V>{
        Node<K, V> next;
        Node<K, V> prev;
        int frequency;
        K key;
        V value;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
        void update(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private final int limit;
    private Node<K, V> head; // latest recent
    private Node<K, V> tail; // oldest
    private Map<K, Node<K, V>> map;

    public LFUCache(int limit){
        this.limit = limit;
        map = new HashMap<>();
    }



    public void set(K key, V value){
        Node<K,V> cur = new Node(key, value);
        if(!map.containsKey(key)){
            insert(cur);
            map.put(key,cur);
            return;

        }
        if(map.containsKey(key)){
            cur = map.get(key);
            cur.frequency++;
            swap(cur);
            head = cur.next == null? cur : cur.next;
        }
        return;

    }

    public int get(K key){
        if(map.get(key) == null){
            return 0;
        }
        Node<K,V> cur =  map.get(key);
        cur.frequency+= 1;
        swap(cur);
        return cur.frequency;
    }


    private void swap(Node<K,V> cur){
        if(cur.next == null){
            return;
        }
        while(cur.next.frequency == cur.frequency){

            Node<K,V> temp = cur.next.next;
            cur.next.next= cur;
            cur.prev = temp;
            cur.next = temp.next;
            temp.next =cur;
        }
        return;

    }

    private void insert(Node<K,V> cur){
        Node<K,V> before = findBefore(cur);
        Node<K,V> after = findAfter(cur);
        if(cur.prev == null){
            cur.next.prev = cur;
            cur =head;
            return;
        }
        if(cur.next == null){
            before.next =cur;
            cur.prev = before;
            cur = tail;
        }

        else{
            cur.next = after;
            cur.prev = before;
            before.next = cur;
            after.prev = cur;

        }
        return;
    }
    private Node<K,V> findBefore(Node<K,V> cur){
        while(head!= null && head.next != null){
            if(head.value == cur.value && head.next.value != cur){
                return head.prev;
            }

        }
        return null;
    }

    private Node<K,V> findAfter(Node<K,V> cur){
        while(head!= null && head.next != null){
            if(head.value == cur.value && head.next.value != cur){
                return head.next;
            }
        }
        return null;
    }

}

