package com.javacore.lesson16;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        System.out.println(functionFirst(" I had lost my key"));
        System.out.println(functionSecond("335555822"));
        System.out.println(functionSecond(335555822));
        System.out.println(functionSecond(1234303));
    }

    public static String functionFirst(String s) {
        return Stream.of(s.split("[ ,.!?;:]")).sorted((a, b) -> Integer.compare(b.length(), a.length())).findFirst().get();
    }
    public static boolean functionSecond(String s) {
        Map<String, Integer> m = Stream.of(s.split("")).filter(a -> Integer.parseInt(a) > 1).collect(Collectors.toMap(a -> a, a -> 1, (a, b) -> a + 1));
        boolean bol = Stream.of(String.valueOf(s).split("")).filter(a -> Integer.parseInt(a) > 1).anyMatch(a -> m.get(a) == Integer.parseInt(a));
        return bol;
    }

    public static boolean functionSecond(Integer s) {
        Map<String, Integer> m = Stream.of(String.valueOf(s).split("")).filter(a -> Integer.parseInt(a) > 1).collect(Collectors.toMap(a -> a, a -> 1, (a, b) -> a + 1));
        boolean bol = Stream.of(String.valueOf(s).split("")).filter(a -> Integer.parseInt(a) > 1).anyMatch(a -> m.get(a) == Integer.parseInt(a));
        return bol;
    }
}
