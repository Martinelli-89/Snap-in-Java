package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private String name;
    String regex = "^^[A-Za-z]+$";

    public Player (String name) {
        if(!Pattern.matches(regex, name)) {
            throw new IllegalArgumentException();
        } else {
            this.name = suits.ANSI_CYAN +  name + suits.ANSI_RESET;
        }
    }

    public String getName() {
        return name;
    }


}
