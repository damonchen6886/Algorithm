package OA;

import java.util.*;

public class SlidingPuzzle {
    public int SlidingPuzzle(List<List<Integer>> board){
        int[][] directions = new int[][]{{1,0},{0,-1},{0,1},{-1,0}};
        int row =board.size();
        int column = board.get(0).size();
        int sum = row* column;
        // construct end string:
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<sum; i++)
            sb.append(i);
        String end = sb.toString();
        end = "123450";
        System.out.println("end = "+ end);
        // prepare for BFS
        sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i< row;i++){
            for(int j = 0 ;j  < column;j++){
                sb.append(String.valueOf(board.get(i).get(j)));
            }
        }
        System.out.println("start =" +sb.toString());
        Queue<String> q = new ArrayDeque<>();
        q.offer(sb.toString());
        visited.add(sb.toString());

//        System.out.println(end);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int index = 0; index < size;index++){
                String curBoard = q.poll();
                if(curBoard.equals(end)){
                    return count;
                }
                int zeroIndex = curBoard.indexOf('0');
                for(int[] dir: directions){
                    int x = zeroIndex/column +dir[0];
                    int y = zeroIndex%column + dir[1];
                    if(x>= 0 && x < row && y>=0 && y< column){
                        int newZeroIndex = x*column+y;
                        System.out.println("newZeroIndex= "+ newZeroIndex);
                        StringBuilder newBoard = new StringBuilder(curBoard);
                        newBoard.setCharAt(zeroIndex,curBoard.charAt(newZeroIndex));
                        newBoard.setCharAt(newZeroIndex, curBoard.charAt(zeroIndex));
                        if(visited.add(newBoard.toString())){
                            System.out.println(newBoard);
                            q.offer(newBoard.toString());
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    class Solution {
        public int slidingPuzzle(int[][] board) {
            int row = board.length;
            int col = board[0].length;
            int total = row * col;
            String start = "";
            String end = "";
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<total; i++)
                sb.append((char)(i + 'a'));
            sb.append('a');
            end = sb.toString();
            sb = new StringBuilder();
            for(int r=0; r<row; r++){
                for(int c=0; c<col; c++){
                    sb.append((char)(board[r][c] + 'a'));
                }
            }
            start = sb.toString();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0; i<total; i++){
                map.put(i, new ArrayList<>());
                if(i % col < col - 1)
                    map.get(i).add(i+1);
                if(i % col > 0)
                    map.get(i).add(i-1);
                if(i + col < total)
                    map.get(i).add(i+col);
                if(i - col >= 0)
                    map.get(i).add(i-col);
            }

            // System.out.println("start >>" + start);
            // System.out.println("end >>" + end);
            // for(List<Integer> l : map.values()){
            //     System.out.println(l);
            // }

            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.add(start);
            visited.add(start);

            int cnt = 0;

            while(!queue.isEmpty()){
                int size = queue.size();
                while(size -- > 0){
                    String cur = queue.poll();
                    if(cur.equals(end)) return cnt;
                    int pos = cur.indexOf("a");
                    for(int j : map.get(pos)){
                        String next = get(cur, pos, j);
                        if(visited.contains(next)) continue;
                        visited.add(next);
                        queue.add(next);
                    }
                }
                cnt++;
            }
            return -1;
        }

        public String get(String str, int i, int j){
            char[] arr = str.toCharArray();
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            return new String(arr);

        }
    }

    public static void main(String[] args) {
        List<Integer> lst1 = new ArrayList<>(List.of(1,2,3));
        List<Integer> lst2 = new ArrayList<>(List.of(4,0,5));
        List<Integer> lst3 = new ArrayList<>(List.of(4,0,5));
        List<Integer> lst4 = new ArrayList<>(List.of(3,2,4));
        List<Integer> lst5 = new ArrayList<>(List.of(1,5,0));
        List<List<Integer>> theList = new ArrayList<>(List.of(lst1,lst2));
        List<List<Integer>> theList2 = new ArrayList<>(List.of(lst4,lst5));
        SlidingPuzzle s = new SlidingPuzzle();
        System.out.println(s.SlidingPuzzle(theList));
//        System.out.println(s.SlidingPuzzle(theList2));
    }

}
