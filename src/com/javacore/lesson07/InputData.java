package com.javacore.lesson07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputData {

    private final ArrayList<Order> orders;

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public InputData(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void startMenu() throws IOException {

        while (true) {
            System.out.println("1 - Menu");
            System.out.println("2 - Exit");
            System.out.print("Enter number: ");
            switch (Integer.parseInt(bufferedReader.readLine())) {
                case 1 -> this.orderFinder();
                case 2 -> {
                    return;
                }
                default -> System.out.println("Try again ");
            }
        }
    }

    public void orderFinder() throws IOException {

        int num;

        System.out.print("Enter Order ID: ");
        num = Integer.parseInt(bufferedReader.readLine());
        Order order = new Order(num);

        if (orders.contains(order)) {
            Order foundOrder = orders.get(orders.indexOf(order));
            System.out.println(foundOrder);
            if (foundOrder.getStatusOrder() != OrderStatus.FAILED && foundOrder.getStatusOrder() != OrderStatus.FINISHED) {
                this.changeMenu(foundOrder);
            }
        } else {
            System.out.println();
            System.out.println("This ID not found in list");
            System.out.println("Order added to list with ID: " + num);
            System.out.println();
            orders.add(order);
        }
    }

    public void changeMenu(Order order) throws IOException {
        while (true) {
            System.out.println("1 - Change Order Status");
            System.out.println("2 - return to menu");
            System.out.print("Enter number: ");

            switch (Integer.parseInt(bufferedReader.readLine())) {
                case 1 -> {
                    while (true) {
                        try {
                            this.changeStatus(order);
                        } catch (InvalidStatusException e) {
                            System.out.println();
                            System.out.println("Invalid Status");
                            System.out.println("Try again ");
                            continue;
                        }
                        return;
                    }
                }
                case 2 -> {
                    return;
                }
                default -> System.out.println("Try again ");
            }
        }
    }

    public void changeStatus(Order order) throws IOException, InvalidStatusException {
        System.out.println();
        System.out.println("1 - IN_PROGRESS");
        System.out.println("2 - FINISHED");
        System.out.println("3 - FAILED");
        System.out.print("Enter number: ");

        switch (Integer.parseInt(bufferedReader.readLine())) {
            case 1 -> order.setStatusOrder(OrderStatus.IN_PROGRESS);
            case 2 -> order.setStatusOrder(OrderStatus.FINISHED);
            default -> order.setStatusOrder(OrderStatus.FAILED);
        }
    }
}
