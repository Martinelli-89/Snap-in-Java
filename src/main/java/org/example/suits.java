package org.example;

public enum suits {

    spades('\u2660'),
    hearts('\u2665'),
    diamonds('\u2666'),
    clubs('\u2663');

    private char code;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private suits(char code) {
        this.code = code;
    }

    public String getCode () {
        if (this.code == '\u2665' || this.code == '\u2666') {
            return "" + ANSI_RED + this.code + ANSI_RESET;
        } else {
            return "" + ANSI_PURPLE + this.code + ANSI_RESET;
        }

    }
}
