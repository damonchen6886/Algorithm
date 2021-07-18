package BFSwithHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    // leetcode 621
    //Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
    // Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete
    // either one task or just be idle.
    //
    //However, there is a non-negative integer n that represents the cooldown period between two same tasks
    // (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
    //
    //Return the least number of units of times that the CPU will take to finish all the given tasks.
    //Input: tasks = ["A","A","A","B","B","B"], n = 2
    //Output: 8
    //Explanation:
    //A -> B -> idle -> A -> B -> idle -> A -> B
    //There is at least 2 units of time between any two same tasks.
    // 思路： 建hashmap 记录每个char出现的次数 从次数多的往次数小的取 一轮取完发现pq为空 就加上差值(idle) 计算总count
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)-> map.get(a)!= map.get(b) ? map.get(b)- map.get(a): a);
        pq.addAll(map.keySet());
        int count = 0;
        while(!pq.isEmpty()){
            //set -1 in case n = 0
            int curNum = -1;
            List<Character> tempList = new ArrayList<>();
            while(!pq.isEmpty() && curNum < n){
                Character curChar = pq.poll();
                map.put(curChar, map.get(curChar)-1);
                if(map.get(curChar) !=0){
                    tempList.add(curChar);
                }
                else{
                    map.remove(curChar);
                }
                count++;
                curNum++;
            }
            pq.addAll(tempList);
            if(pq.isEmpty()){
                break;
            }
            count+= (n-curNum);
        }
        return count;
    }
}
