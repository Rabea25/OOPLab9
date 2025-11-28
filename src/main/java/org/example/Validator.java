package org.example;

import java.util.*;

public interface Validator {
    public List<String> validate(Board board);

    default ArrayList<Integer> duplicates(int[] nums, int num){
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i=0; i<nums.length; i++) if(nums[i]==num) positions.add(i);
        return positions;
    }

    default void Check(int[] part, String partName, List<String> results, int i){
        for(int num=1; num<=9; num++){
            ArrayList<Integer> positions = duplicates(part, num);
            if(positions.size() > 1){
                StringBuilder e = new StringBuilder();
                e.append(partName).append(i+1).append(" #").append(num).append(", [");
                for(int pos : positions) e.append(pos).append(", ");
                e.deleteCharAt(e.length()-1);
                e.deleteCharAt(e.length()-1);
                e.append("]");
                results.add(e.toString());
            }
        }

    }
}
