package com.javacore.lesson05;

import java.io.IOException;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) throws IOException {
        TreeSet<Employee> treeSet = new TreeSet<>();

        Input input = new Input(treeSet);

        input.menu();

    }
}

