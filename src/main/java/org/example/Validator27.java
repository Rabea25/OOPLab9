package org.example;

import java.util.*;

public class Validator27 implements Validator {
    public List<String> validate(Board board){
        List<String> results = Collections.synchronizedList(new ArrayList<>());

        ArrayList<Thread> threads = new ArrayList<>();

        for(int i=0; i<9; i++) {
            int finalI = i;
            threads.add(new Thread(() -> Check(board.getRow(finalI), "ROW ", results, finalI)));
        }
        for(int i=0; i<9; i++) {
            int finalI = i;
            threads.add(new Thread(() -> Check(board.getCol(finalI), "COL ", results, finalI)));
        }
        for(int i=0; i<9; i++) {
            int finalI = i;
            threads.add(new Thread(() -> Check(board.getBox(finalI), "BOX ", results, finalI)));
        }

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
