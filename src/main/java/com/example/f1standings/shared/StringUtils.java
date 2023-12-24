package com.example.f1standings.shared;

public class StringUtils {

    public static boolean containsOnlyLettersAndOrHyphens(String string) {
        return string.matches("^[a-zA-Z]+(?:-[a-zA-Z]+)?$");

    }
}
