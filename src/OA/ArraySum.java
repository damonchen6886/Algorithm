package OA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraySum {
    public boolean sumArray(List<Integer> input, List<Integer> tests){
        Set<Integer> set2 = new HashSet<>(tests);
        for(int i =0; i < input.size();i++){
            for(int j = i+1; j < input.size();j++){
                if(set2.contains(input.get(i) + input.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(-1,8,3));
        ArrayList<Integer> test1 = new ArrayList<>(List.of(3,7,2));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(9,6,12));
        ArrayList<Integer> test2 = new ArrayList<>(List.of(1,2,3));
        System.out.println(new ArraySum().sumArray(input1,test1));
        System.out.println(new ArraySum().sumArray(input2,test2));
    }
}
