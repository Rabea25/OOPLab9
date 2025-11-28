package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    int[][] board = new int[9][9];
    public Board(String FileName) throws Exception {
        Scanner scanner = new Scanner(new File(FileName));
        String[] line;
        for(int i=0; i<9; i++){
            line = scanner.nextLine().split(",");
            if(line.length!=9) throw new Exception("Invalid input board.");
            for(int j=0; j<9; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        scanner.close();
    }

    public int[][] getBoard(){
        return board;
    }
    public int[] getRow(int r) {return board[r];}
    public int[] getCol(int c){
        int[] col = new int[9];
        for(int i=0; i<9; i++) col[i] = board[i][c];
        return col;
    }
    public int[] getBox(int b){
        int[] box = new int[9];
        int sti = (b/3)*3, stj = (b%3)*3, k = 0;
        for(int i=sti; i<sti+3; i++){
            for(int j=stj; j<stj+3; j++){
                box[k++] = board[i][j];
            }
        }
        return box;
    }

}
