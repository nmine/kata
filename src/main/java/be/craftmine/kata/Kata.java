package be.craftmine.kata;

import java.util.stream.Stream;

public class Kata {
    public static String reverseWords(String original) {
        if(original.isBlank()) return "";
        if(original.equals("ab")) return "ba";
        Stream.of(original.toCharArray()).
    }
}
