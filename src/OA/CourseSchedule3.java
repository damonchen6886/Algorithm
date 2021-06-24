package OA;

import java.util.*;

// [prerequisite, course]
public class CourseSchedule3 {
    public String findOrder(String[][] pre) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Set<String> course = new HashSet<>();
        for(int i = 0; i< pre.length;i++){
            map.putIfAbsent(pre[i][0], new ArrayList<String>());
            map.get(pre[i][0]).add(pre[i][1]);
            indegree.put(pre[i][1], indegree.getOrDefault(pre[i][1],0)+1);
            course.add(pre[i][0]);
            course.add(pre[i][1]);
        }
        Queue<String> q = new ArrayDeque<>();
        for(String c: course){
            if(!indegree.containsKey(c)){
                q.offer(c);
            }
        }
        System.out.println(q);
        String[] result = new String[course.size()];
        int index = 0;
        while(!q.isEmpty()){
            String cur =q.poll();
            result[index++] = cur;
            ArrayList<String> arr = map.get(cur);
            if(arr != null){
                for(int i = 0; i < arr.size();i++){
                    String  next = arr.get(i);
                    indegree.put(next,indegree.get(next)-1);
                    if(indegree.get(next) ==0){
                        q.offer(next);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(result));
        return result[course.size()/2];

    }

    public static void main(String[] args) {
        String[][] pre = new String[][]{{"DS","Algo"},{"FoudofCS","OS"},{"network","Architect"},{"Algo","FoudofCS"},{"Architect","DS"},{"SoftwareDesign","network"}};
        CourseSchedule3 c = new CourseSchedule3();
        System.out.println(c.findOrder(pre));
    }
}
