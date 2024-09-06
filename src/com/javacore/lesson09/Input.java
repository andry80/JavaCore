package com.javacore.lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public Input() {
    }

    public String inputParameter(String parameter) {

        try {
            System.out.println("enter " + parameter + ": ");
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
}
