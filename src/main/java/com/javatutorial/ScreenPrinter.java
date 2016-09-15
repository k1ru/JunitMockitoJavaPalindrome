package com.javatutorial;

public class ScreenPrinter {

    public void printDecision(String string, boolean decision) {
        System.out.println("String " + string + " is" + (decision ? " " : " not ") + "a palindrome");
    }
}
