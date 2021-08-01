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
            // map.computeIfAbsent(pre[i][1], x-> new ArrayList<>()).add(pre[i][0]);
            map.putIfAbsent(pre[i][1], new ArrayList<>());
            map.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }
        System.out.println(pre.length + " "+ map.size());
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


    // map another way:
    public int[] findOrder2(int num, int[][] pre) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[num];
        //如果不加if(arr!= null) 就得让map的长度等于pre的长度避免NPE
        for(int i = 0; i< num;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0;i < pre.length;i++){
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
            for(int i = 0; i< arr.size();i++){
                int next = arr.get(i);
                indegree[next]--;
                if(indegree[next] ==0){
                    q.offer(next);
                }
            }
        }
        return index == num ? result: new int[0];

    }

    // Array 版本
    public int[] findOrder3(int numCourses, int[][] prerequisites) {
        List<List<Integer>> course = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses;i++){
            course.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            course.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i< numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            result[index++] = cur;
            int size = course.get(cur).size();
            for(int i = 0 ; i< size;i++){
                int next = course.get(cur).get(i);
                indegree[next]--;
                if(indegree[next] ==0){
                    q.offer(next);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
;



    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        System.out.println(Arrays.toString(c.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(c.findOrder(4, new int[][]{{1, 0},{2,0},{3,1},{3,2}})));
    }


}
