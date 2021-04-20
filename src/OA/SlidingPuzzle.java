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
