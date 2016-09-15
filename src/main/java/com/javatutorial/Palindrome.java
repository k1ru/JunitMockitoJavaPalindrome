package com.javatutorial;

public class Palindrome {
    private ScreenPrinter screenPrinter;
    private StringGenerator stringGenerator;

    public Palindrome() {
        setScreenPrinter(new ScreenPrinter());
        setStringGenerator(new HardcodedStringGenerator());
    }

    public static void main(String[] args) {
        Palindrome pal = new Palindrome();
        pal.checkPalindrome();
    }

    public void checkPalindrome() {
        String s = "";

        try {
            s = getStringGenerator().getString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        screenPrinter.printDecision(s, doCheckPalindrome(trimSpaces(s)));
    }

    private boolean doCheckPalindrome(String s) {
        boolean isPalindrome = true;
        s = s.toLowerCase();
        String[] arr = s.split("");

        for (int i = 0; i < arr.length / 2; i++) {
            if (!arr[i].equals(arr[arr.length - 1 - i])) isPalindrome = false;
        }
        return isPalindrome;
    }

    public String trimSpaces(String s) {
        return s.replaceAll("\\s+", "");
    }

    public void setScreenPrinter(ScreenPrinter screenPrinter) {
        this.screenPrinter = screenPrinter;
    }

    public StringGenerator getStringGenerator() {
        return stringGenerator;
    }

    public void setStringGenerator(StringGenerator stringGenerator) {
        this.stringGenerator = stringGenerator;
    }
}
