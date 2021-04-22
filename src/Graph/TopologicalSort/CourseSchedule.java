package Graph.TopologicalSort;

import java.util.*;

public class CourseSchedule {

    //There are a total of n courses you have to take labelled from 0 to n - 1.
    //
    //Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
    //
    //Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
    //
    //If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array

    // 思路： 记录图每个node的indegree 吧indegree为0的点作为起始点，来放入q 然后遍历整个图
    // 每加一层就把这一层指向下一层的indegree减去 就能实现按indegree的数量按层添加
    // 举例： 1 --> 2 ---> 4
    //       1  -->3 ----4
    // 按层分： (indegree 0 :1) (indegree 1 :2,3) (indegree 2: 4)
    // expected answer: [1,2,3,4] or [1,3,2,4]
    public int[] findOrder(int num, int[][] pre) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[num];
        for(int i = 0;i < pre.length;i++){
            map.putIfAbsent(pre[i][1], new ArrayList<>());
            map.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i< num;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int[] result = new int[num];
        int index =0;

        while(!q.isEmpty()){
            int cur = q.poll();
            result[index++] = cur;
            ArrayList<Integer> arr = map.get(cur);
            if(arr!= null){
                for(int i = 0; i< arr.size();i++){
                    int next = arr.get(i);
                    indegree[next]--;
                    if(indegree[next] ==0){
                        q.offer(next);
                    }
                }
            }
        }
        return index == num ? result: new int[0];

    }


}
