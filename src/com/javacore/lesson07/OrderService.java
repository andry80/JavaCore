package com.javacore.lesson07;

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

    public static void main(String[] args) throws IOException, InvalidStatusException {
        ArrayList<Order> orders = new ArrayList<>();

        FileReadWriter.readFromFile(orders);

        InputData input = new InputData(orders);
        OrderService program = new OrderService(input);
        program.startService();

        FileReadWriter.writeToFile(orders);
    }

}
