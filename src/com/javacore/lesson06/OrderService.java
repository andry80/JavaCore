package com.javacore.lesson06;

import java.io.IOException;
import java.util.ArrayList;

public class OrderService {

    Input input;

    public OrderService(Input input) {
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
        OrderService program = new OrderService(input);
        program.start();
    }

}
