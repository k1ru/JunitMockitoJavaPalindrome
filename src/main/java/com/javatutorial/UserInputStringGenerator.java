package com.javatutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mdrb36 on 14.09.2016.
 */
public class UserInputStringGenerator implements StringGenerator {

    public String getString() {
        String input = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(">>> Input string: " + input);
        return input;
    }
}
