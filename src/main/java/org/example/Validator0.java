package org.example;

import java.util.ArrayList;

public class Validator0 implements Validator {
    public ArrayList<String> validate(Board board){
        ArrayList<String> results = new ArrayList<>();
        for(int i=0; i<9; i++){
            Check(board.getRow(i), "ROW ", results, i);
        }
        for(int i=0; i<9; i++){
            Check(board.getCol(i), "COL ", results, i);
        }
        for(int i=0; i<9; i++){
            Check(board.getBox(i), "BOX ", results, i);
        }
        return results;
    }
}
