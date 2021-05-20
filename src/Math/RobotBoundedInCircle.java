package Math;

public class RobotBoundedInCircle {
    //1041
//    On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
//
//"G": go straight 1 unit;
//"L": turn 90 degrees to the left;
//"R": turn 90 degrees to the right.
//The robot performs the instructions given in order, and repeats them forever.
//
//Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
//    Input: instructions = "GGLLGG"
//Output: true
//Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
//When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
//    Input: instructions = "GL"
//Output: true
//Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...

//思路： 只要判断在一次循环中是否到达远点或者结束时的方向是否和起始方向不同即可（因为题目给定repeats instructions forever.）
    public boolean isRobotBounded(String s) {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;
        int[] pos = new int[]{0,0};
        for(int i =0 ; i < s.length();i++){
            char cur = s.charAt(i);
            if(cur == 'R'){
                dir = (dir+1)%4;
            }
            else if(cur == 'L'){
                dir = (dir+3)%4;
            }
            else{
                pos[0] += directions[dir][0];
                pos[1] += directions[dir][1];
            }
        }
        return pos[0] == 0 && pos[1] == 0 || dir>0;

    }

}
