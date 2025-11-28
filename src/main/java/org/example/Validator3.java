package org.example;


import java.util.*;

public class Validator3 implements Validator {
    public List<String> validate(Board board){
        List<String> results = Collections.synchronizedList(new ArrayList<>());
        ArrayList<Thread> threads = new ArrayList<>();

        threads.add(new Thread(() -> {
            for(int i=0; i<9; i++) Check(board.getRow(i), "ROW ", results, i);
        }));
        threads.add(new Thread(() -> {
            for(int i=0; i<9; i++) Check(board.getCol(i), "COL ", results, i);
        }));
        threads.add(new Thread(() -> {
            for(int i=0; i<9; i++) Check(board.getBox(i), "BOX ", results, i);
        }));

        for(Thread t : threads) t.start();
        for(Thread t : threads){
            try{
                t.join();
            }
            catch (Exception e){

            }
        }
        return results;
    }
}
