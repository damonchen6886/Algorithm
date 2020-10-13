package 做题笔记;

import java.util.*;

public class ReorderLogFile937 {
    // 麻烦的地方： 处理 log content 有重复的情况
    // log content 若重复 还需要看题目给的 identifier， 用identifier来排序
    // 比如： z abc， a abc， b abc
    // 排序完为： a abc， b abc， z abc 虽然在排序的时候只考虑 content 但是content一样的时候 还是得考虑identifier
    // 1. pq的优势
    // pq 允许duplicate存在 所以 在sort的同时不会导致 map 只能put一次的情况
    // 2. TreeMap
    // TreeMap 的方法 需要考虑 无论 吧log content 放在key 还是value 都会存dup的情况
    // 若放在key 就得加一些自己的 identifier 来保证 重复的key 都放在了map里
    // 若放在val key最好是存index 这样避免重复的content志存一次的情况
    //heap version:
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            String[] result = new String[logs.length];
            if(logs.length ==0){
                return result;
            }
            List<String> textLog = new ArrayList<>();
            List<String> intLog = new ArrayList<>();
            for(int i = 0; i< logs.length; i++){
                if(logs[i].split(" ")[1].charAt(0)<'a'){
                    intLog.add(logs[i]);
                }
                else{
                    textLog.add(logs[i]);
                }
            }
            Collections.sort(textLog);
            PriorityQueue<String> pq= new PriorityQueue();
            for(int i =0; i < textLog.size();i++){
                String log = textLog.get(i);
                String header = log.split(" ")[0];
                String rest = log.substring(log.indexOf(" "),log.length());
                pq.offer(rest);
            }
            int count = 0;
            while(!pq.isEmpty()){
                String cur = pq.poll();
                for(String log: textLog){
                    String rest =log.substring(log.indexOf(" "),log.length());
                    if(cur.equals(rest)){
                        result[count] = log;
                        textLog.remove(log);
                        break;
                    }
                }
                count++;
            }
            for(int i = 0;i < intLog.size();i++){
                result[count] = intLog.get(i);
                count++;
            }
            return result;
        }
    }
    //______________________
    //TreeMap version:
    class Solution2 {
        public String[] reorderLogFiles(String[] logs) {
            String[] result = new String[logs.length];
            if(logs.length ==0){
                return result;
            }
            List<String> textLog = new ArrayList<>();
            List<String> intLog = new ArrayList<>();
            for(int i = 0; i< logs.length; i++){
                if(logs[i].split(" ")[1].charAt(0)<'a'){
                    intLog.add(logs[i]);
                }
                else{
                    textLog.add(logs[i]);
                }
            }
            Collections.sort(textLog);
            TreeMap<Integer, String> map = new TreeMap<>();
            for(int i =0; i < textLog.size();i++){
                String log = textLog.get(i);
                String header = log.split(" ")[0];
                String rest = log.substring(log.indexOf(" "),log.length());
                map.put(i, rest);
            }
            List<Map.Entry<Integer,String>> mapList = new ArrayList<>(map.entrySet());
            mapList.sort(new Comparator<Map.Entry<Integer, String>>() {
                @Override
                public int compare(Map.Entry<Integer, String> s1, Map.Entry<Integer, String> s2) {
                    return s1.getValue().compareTo(s2.getValue());
                }
            });

            int count =0;
            for(Map.Entry<Integer,String> p: mapList){
                String curr = p.getValue();
                for(String item : textLog){
                    String rest = item.substring(item.indexOf(" "),item.length());
                    if(curr.equals(rest)){
                        result[count] = item;
                        textLog.remove(item);
                        break;
                    }
                }
                count++;
            }
            for(int i = 0;i < intLog.size();i++){
                result[count] = intLog.get(i);
                count++;
            }
            return result;
        }
    }

}