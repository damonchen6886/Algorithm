package LFULRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // Most Efficient way
    // Method: creat a dummy head and tail node in double likedList, create a hashMap to save all node in linkedList
    // every time when we get a node, we remove the node from the linkedList and put it in the front
    // every time when we put a node, we put it to the front, and remove the last node
    class LRUCache1{

        class Node{
            int key;
            int val;
            Node prev;
            Node next;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        int capacity;
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        HashMap<Integer, Node> map = new HashMap<>();

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            this.head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.val;
            }
            else{
                return -1;
            }
        }
        public void put(int key, int value) {
            if(map.containsKey(key)){
                remove(map.get(key));
            }
            if(map.size() == capacity){
                remove(tail.prev);
            }
            insert(new Node(key, value));
        }

        private void remove(Node node){
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private void insert(Node node){
            map.put(node.key,node);
            Node headnext = head.next;
            head.next = node;
            node.prev = head;
            node.next =headnext;
            headnext.prev = node;
        }
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
