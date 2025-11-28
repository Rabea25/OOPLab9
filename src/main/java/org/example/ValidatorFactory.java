package org.example;

public class ValidatorFactory {
    public static Validator getValidator(int mode){
        return switch (mode) {
            case 0 -> new Validator0();
            case 3 -> new Validator3();
            case 27 -> new Validator27();
            default -> null;
        };
    }
}
