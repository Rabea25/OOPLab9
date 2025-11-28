package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.err.println("Provide both input file and execution mode (0,3,27).");
            return;
        }

        String FileName = args[0];
        Board board = new Board(FileName);

        int mode = Integer.parseInt(args[1]);
        if(mode != 0 && mode != 3 && mode != 27) {
            System.err.println("Invalid mode, mode should be 0 or 3 or 27.");
            return;
        }

        Validator validator = ValidatorFactory.getValidator(mode);
        List<String> results = validator.validate(board);

        if(results.isEmpty()){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
            for(String s : results) System.out.println(s);
        }

    }
}