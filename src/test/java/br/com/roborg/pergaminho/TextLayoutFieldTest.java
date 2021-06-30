package br.com.roborg.pergaminho;

import org.junit.jupiter.api.Test;

import static br.com.roborg.pergaminho.TextField.Case.*;
import static br.com.roborg.pergaminho.TextField.Pad.*;
import static org.junit.jupiter.api.Assertions.*;

public class TextLayoutFieldTest {

    static final int SIZE = 10;
    static final String LARGE_TEXT = "Lorem ipsum dolor sit amet";
    static final String SMALL_TEXT = "Lorem";
    static final String RPAD_SMALL_TEXT_10 = "Lorem     ";
    static final String LPAD_SMALL_TEXT_10 = "     Lorem";

    @Test
    public void textLayoutLargeTextTest(){
        TextField field = new TextField(10);
        field.fromString(LARGE_TEXT);
        assertEquals(field.size(), field.toString().length());
    }

    @Test
    public void textLayoutSmallTextTest(){
        TextField field = new TextField(10);
        field.fromString(SMALL_TEXT);
        assertTrue(field.toString().length() <= SIZE);
    }

    @Test
    public void textLayoutSmallTextTestLpad(){
        TextField field = new TextField(10, LPAD, ' ');
        field.fromString(SMALL_TEXT);
        assertTrue(field.toString().length() == SIZE);
        assertTrue(LPAD_SMALL_TEXT_10.equals(field.toString()));
    }

    @Test
    public void textLayoutSmallTextTestRpad(){
        TextField field = new TextField(10, RPAD, ' ');
        field.fromString(SMALL_TEXT);
        assertTrue(field.toString().length() == SIZE);
        assertTrue(RPAD_SMALL_TEXT_10.equals(field.toString()));
    }

    @Test
    public void textLayoutSmallTextTestRpadUpper(){
        TextField field = new TextField(10, RPAD, ' ', UPPER);
        field.fromString(SMALL_TEXT);
        assertTrue(field.toString().length() == SIZE);
        assertTrue(RPAD_SMALL_TEXT_10.toUpperCase().equals(field.toString()));
    }

    @Test
    public void textLayoutSmallTextTestRpadLower(){
        TextField field = new TextField(10, RPAD, ' ', LOWER);
        field.fromString(SMALL_TEXT);
        assertTrue(field.toString().length() == SIZE);
        assertTrue(RPAD_SMALL_TEXT_10.toLowerCase().equals(field.toString()));
    }


}
