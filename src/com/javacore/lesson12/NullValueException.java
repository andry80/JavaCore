package com.javacore.lesson12;

public class NullValueException extends Exception {

    public NullValueException(String text) {
        super(text + " field is null");
    }
}

