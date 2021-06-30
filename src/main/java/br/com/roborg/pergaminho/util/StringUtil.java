package br.com.roborg.pergaminho.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access= PRIVATE)
public class StringUtil {

    /**Completa com character à esquerda*/
    public static String lpad(CharSequence inputString, int length, char character) {
        if(inputString == null || length == 0) return "";
        return String.format("%1$" + length + "s", inputString).replace(' ', character);
    }

    /**Completa com character à direita*/
    public static String rpad(CharSequence inputString, int length, char character) {
        if(inputString == null || length == 0) return "";
        return String.format("%1$-" + length + "s", inputString).replace(' ', character);
    }

}
