package day34;

import java.util.HashMap;
import java.util.Map;

//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//Return adeep copyof the list.
//Example 1:
//
//Input:
//
//{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
//
//Explanation:
//
//Node 1's value is 1, both of its next and random pointer points to Node 2.
//Node 2's value is 2, its next pointer points to null and its random pointer points
public class copyNode {
        class RandomLinkedList{
            public int value;
            public RandomLinkedList next;
            public RandomLinkedList random;
            public RandomLinkedList(int value){
                this.value = value;
            }
        }
        // key:itself <key:next value:random>
        HashMap<RandomLinkedList, HashMap<RandomLinkedList,RandomLinkedList>> map = new HashMap<>();
        public RandomLinkedList copyNode(RandomLinkedList head){
            RandomLinkedList original =  head;
            RandomLinkedList dummy = new RandomLinkedList(-1);
            RandomLinkedList cur = new RandomLinkedList(head.value); // traversed the copy value
            dummy.next = cur;
            while(original != null){
                HashMap<RandomLinkedList,RandomLinkedList> mapRandom = new HashMap<>();
                mapRandom.put(original.next, original.random);
                map.put(original, mapRandom);
                original = original.next;
            }
            while(head != null){
                RandomLinkedList next = new RandomLinkedList(-1);
                RandomLinkedList random = new RandomLinkedList(-1);;
                for(Map.Entry<RandomLinkedList, RandomLinkedList> entry : map.get(head).entrySet()){
                     next = new RandomLinkedList(entry.getKey().value);
                     random = new RandomLinkedList(entry.getValue().value);
                }
                cur.next =next;
                cur.random = random;
                head = head.next;
                cur = cur.next;
            }
            return dummy.next;
        }

        ////////////////////////////////////

        class Node{
            public int value;
            public Node next;
            public Node random;
            public Node(int value){
                this.value = value;
            }

        // key:itself value: copy
        HashMap<Node, Node> map = new HashMap<>();
        public Node copyNode(Node head){
            if(head == null){
                return new Node(0);
            }
            Node original = head;
            Node copy = getCopy(original);
            while(original != null){
                copy.random = getCopy(original.random);
                copy.next = getCopy(original.next);
                original = original.next;
                copy = copy.next;
            }
            return getCopy(head);
        }
        private Node getCopy(Node node){
            if(node == null){
                return null;
            }
//         Node copy = new Node(node.value);
//         map.put(node, copy);
//         return copy;

            if(!map.containsKey(node)){
                Node copy = new Node(node.value);
                map.put(node, copy);
                return copy;
            }
            return map.get(node);
        }


        //-------------------------------------------------------------------------------
        ///////O(1)
        // key:itself value: copy
        HashMap<Node, Node> visited = new HashMap<Node, Node>();

        public Node getClonedNode(Node node) {
            // If the node exists then
            if (node != null) {
                // Check if the node is in the visited dictionary
                if (this.visited.containsKey(node)) {
                    // If its in the visited dictionary then return the new node reference from the dictionary
                    return this.visited.get(node);
                } else {
                    // Otherwise create a new node, add to the dictionary and return it
                    this.visited.put(node, new Node(node.value));
                    return this.visited.get(node);
                }
            }
            return null;
        }

        public Node copyRandomList(Node head) {

            if (head == null) {
                return null;
            }

            Node oldNode = head;

            // Creating the new head node.
            Node newNode = new Node(oldNode.value);
            this.visited.put(oldNode, newNode);

            // Iterate on the linked list until all nodes are cloned.
            while (oldNode != null) {
                // Get the clones of the nodes referenced by random and next pointers.
                newNode.random = this.getClonedNode(oldNode.random);
                newNode.next = this.getClonedNode(oldNode.next);

                // Move one step ahead in the linked list.
                oldNode = oldNode.next;
                newNode = newNode.next;
            }
            return this.visited.get(head);
        }


    }




}


