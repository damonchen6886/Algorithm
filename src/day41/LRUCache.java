package day41;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        int val;
        int key;
        Node prev;
        Node next;
        public Node(int val, int key){
            this.val = val;
            this.key = key;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    // adjusable
    private int lastKey;
    private int head;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node temp = map.get(key);
        set(key, temp.val);
        return temp.val;
    }

    public void set(int key, int value){
        Node cur = new Node(value,key);
        if(map.isEmpty()){
            map.put(key, cur);
            lastKey = key;
            head = key;
            return;
        }
        if(!map.containsKey(key)){
            if(map.size() < capacity){
                Node lastNode = map.get(lastKey);
                lastNode.next = cur;
                map.put(key,cur);
                lastKey = key;
                return;
            }
            else{
                Node topNode = map.get(head);
                Node nextNode = topNode.next;
                // update 2nd node pointer
                nextNode.prev = cur;
                map.put(key, cur);
                // remove 1st element in map;
                map.remove(head);
                head = key;
                return;
            }
        }
        if(map.containsKey(key)){
            if(map.size() == 1 || key == lastKey){
                return;
            }
            if( key == head){
                Node topNode = map.get(head);
                Node nextNode = topNode.next;
                // update 2nd node pointer
                nextNode.prev = null;
                Node lastNode  = map.get(lastKey);
                lastNode.next = cur;
                map.put(key, cur);
                // remove 1st element in map;
                map.remove(head);
                head = nextNode.val;
                lastKey = key;
                return;
            }
            // remove existing key
            Node before = map.get(key).prev;
            Node after = map.get(key).next;
            before.next = after;
            after.prev = before;
            map.remove(key);
            // add key to the end;
            Node lastNode = map.get(lastKey);
            lastNode.next = cur;
            map.put(key,cur);
            lastKey =key;
            return;
        }
        return;
    }
    //-------------------------------------------


    public  class LRUCache2<K, V>{


        // Implement for double linked list
         class Node<K, V>{
            Node<K, V> next;
            Node<K, V> prev;
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

        // constructor
        public LRUCache2(int limit){
            this.limit = limit;
            this.map = new HashMap<>();
        }

        public void set(K key, V value){
            Node<K, V> node = null;
            // case 1: contains key
            if(map.containsKey(key)){
                node = map.get(key);
                node.value = value;
                remove(node);
            } else if(map.size() < limit){
                // case 2: do not contains key and the size is smaller than limit
                node = new Node<K, V>(key, value);
            } else {
                node = tail;
                remove(node);
                node.update(key, value);
            }
            append(node);
        }

        public V get(K key){
            Node<K,V> node = map.get(key);
            if(node == null){
                return null;
            }
            // update to the latest recent key and value
            remove(node);
            append(node);
            return node.value;
        }

        private Node<K, V> append(Node<K, V> node){
            map.put(node.key, node);
            // case 1: if it is the first node
            if(head == null){
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            return node;
        }

        private Node<K, V> remove(Node<K, V> node){
            map.remove(node.key);
            if(node.prev != null){
                node.prev.next = node.next;
            }
            if(node.next != null){
                node.next.prev = node.prev;
            }
            // Maintain the head and the tail
            if(node == head){
                head = head.next;
            }
            if(node == tail){
                tail = tail.prev;
            }
            node.next = node.prev = null;
            return node;
        }

    }

}
