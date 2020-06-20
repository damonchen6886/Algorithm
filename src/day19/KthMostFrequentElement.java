package day19;

import java.util.*;

public class KthMostFrequentElement {

//    Given a non-empty list of words, return the k most frequent elements.
//    Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
//
//    Input:
//            ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//
//    Output:
//            ["i", "love"]
//
//    Explanation:
//            "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.

    public List<String> topKFrequent(String[] words, int k){
        Map<String, Integer> count = new HashMap<String, Integer>();
        List<String> result = new LinkedList<String>();
        for(String word:words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        Queue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(count.get(a).equals(count.get(b))){
                    // sort in alphabetical order
                    a.compareTo(b);
                }
                return count.get(a) > count.get(b) ? -1:1;
            }
        });
        for(String word : count.keySet()){

            pq.offer(word);

        }
        for(int i = 0; i < k; i++){
            result.add(pq.poll());
        }


        return result;

    }


    public List<String> topKFrequent2(String[] words, int k){
        List<String> result = new LinkedList<String>();
        Map<String, Node> map = new HashMap<String, Node>();
        for(String s: words){
            if(!map.containsKey(s)){
                map.put(s, new Node(s));
            } else {
                map.get(s).increase();
            }
        }
        Queue<Node> pq = new PriorityQueue<Node>((a, b) -> a.count == (b.count) ? a.s.compareTo(b.s) : b.count - a.count);
        for(Map.Entry<String, Node> entry : map.entrySet()){
            pq.offer(entry.getValue());
        }
        for(int i = 0; i < k; i++){
            result.add(pq.poll().s);
        }
        return result;
    }



    class Node{
        public String s;
        public int count;
        public Node(String s){
            this.s = s;
            count = 1;
        }
        public void increase(){
            this.count++;
        }
    }

}
