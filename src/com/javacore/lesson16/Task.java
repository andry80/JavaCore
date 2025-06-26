package com.javacore.lesson16;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        System.out.println(findLongestWord("I had lost my key"));
        System.out.println(hasDigitWithMatchingCount("335555822"));
        System.out.println(hasDigitWithMatchingCount(335555822));
        System.out.println(hasDigitWithMatchingCount(123430));
    }

    public static String findLongestWord(String s) {
        return Stream.of(s.trim().split("[ ,.!?;:]"))
                .filter(word -> !word.isEmpty())
                .max(Comparator.comparingInt(String::length))
                .get();
    }

    public static boolean hasDigitWithMatchingCount(String s) {
        Map<String, Integer> m = Stream.of(s.split(""))
                .filter(a -> Integer.parseInt(a) > 1)
                .collect(Collectors.toMap(a -> a, a -> 1, (a, b) -> a + 1));
        boolean bol = Stream.of(String.valueOf(s)
                .split(""))
                .filter(a -> Integer.parseInt(a) > 1)
                .anyMatch(a -> m.get(a) == Integer.parseInt(a));
        return bol;
    }

    public static boolean hasDigitWithMatchingCount(Integer s) {
        return hasDigitWithMatchingCount(String.valueOf(s));
    }
}
