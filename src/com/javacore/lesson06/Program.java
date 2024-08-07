package com.javacore.lesson06;

import java.io.IOException;
import java.util.ArrayList;

public class Program {

    Input input;

    public Program(Input input) {
        this.input = input;
    }

    public void start() throws IOException {
        input.menu();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Order> orders = new ArrayList<>();

        orders.add(new Order(10));
        orders.add(new Order(2));
        orders.add(new Order(6));
        orders.add(new Order(5));

        Input input = new Input(orders);
        Program program = new Program(input);
        program.start();
    }

}
