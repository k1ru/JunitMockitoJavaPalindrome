package com.javatutorial;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PalindromeTest {
    private Palindrome palindrome;
    @Mock
    private ScreenPrinter sp;
    @Mock
    private StringGenerator sg;

    @Before
    public void tearUp() {
        MockitoAnnotations.initMocks(this);
        palindrome = new Palindrome();
        palindrome.setScreenPrinter(sp);
        palindrome.setStringGenerator(sg);
    }

    @Test
    public void shouldReturnEmptyStringWhenThreeSpaces() {
        testTrim("   ", "");
    }

    @Test
    public void shouldRemoveAllSpaces() {
        testTrim(" asdf asdf ", "asdfasdf");
    }

    private void testTrim(String value, String expectedResult) {
        String actualResult = palindrome.trimSpaces(value);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void stringAraaraShouldBePalindrome() throws Exception {
        String value = "ara ara";

        when(sg.getString()).thenReturn(value);
        testPalindrome(value, true);
    }

    @Test
    public void stringWithLeadSpaceShouldBePalindrome() throws Exception {
        String value = " kkllkk";

        when(sg.getString()).thenReturn(value);
        testPalindrome(value, true);
    }

    @Test
    public void shouldReturnEmptyStringWhenExceptionIsThrown() throws Exception {
        String value = " kkllkk";

        when(sg.getString()).thenThrow(new RuntimeException());
        testPalindrome("", true);
    }

    private void testPalindrome(String value, boolean isPalindrome) throws Exception {
        palindrome.checkPalindrome();
        verify(sp, times(1)).printDecision(value, isPalindrome);
    }
}