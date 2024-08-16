package com.javacore.lesson06;

import java.io.IOException;
import java.util.ArrayList;

public class OrderService {

    InputData input;

    public OrderService(InputData input) {
        this.input = input;
    }

    public void startService() throws IOException {
        input.startMenu();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Order> orders = new ArrayList<>();

        InputData input = new InputData(orders);
        OrderService program = new OrderService(input);
        program.startService();
    }

}
