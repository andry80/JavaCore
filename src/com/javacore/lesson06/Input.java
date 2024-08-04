package com.javacore.lesson06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input {

    ArrayList arrayList;

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public Input(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public boolean menu() throws IOException {

        while (true) {
            System.out.println("1 - Menu");
            System.out.println("2 - Exit");
            System.out.print("Enter number: ");
            switch (Integer.parseInt(bufferedReader.readLine())) {
                case 1 -> this.enter();
                case 2 -> {
                    return true;
                }
                default -> {
                    System.out.println("Try again ");
                    continue;
                }
            }
        }
    }

    public void enter() throws IOException {

        int num;

        System.out.print("Enter Order ID: ");
        num = Integer.parseInt(bufferedReader.readLine());
        Order order = new Order(num);

        if (arrayList.contains(order)) {
            Order order1 = (Order) arrayList.get(arrayList.indexOf(order));
            this.view(order1);
        } else {
            System.out.println();
            System.out.println("This ID not found in list");
            System.out.println("Order added to list with ID: " + num);
            System.out.println();
            arrayList.add(order);
        }
    }

    public void choise(Order order) throws IOException {
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
                default -> {
                    System.out.println("Try again ");
                    continue;
                }
            }
        }
    }

    public void view(Order order) throws IOException {

        System.out.println();
        System.out.println("Order ID: " + order.getId());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Creating Order time: " + Time.time(order.getStart()));
        System.out.println("Updating Order time: " + Time.time(order.getUpdate()));
        System.out.println();
        if (order.getStatus() == OrderStatus.FINISHED || order.getStatus() == OrderStatus.FAILED) {
            return;
        } else {
            this.choise(order);
        }

    }

    public void changeStatus(Order order) throws IOException, InvalidStatusException {
        System.out.println();
        System.out.println("1 - IN_PROGRESS");
        System.out.println("2 - FINISHED");
        System.out.println("3 - FAILED");
        System.out.print("Enter number: ");

        switch (Integer.parseInt(bufferedReader.readLine())) {
            case 1 -> order.setStatus(OrderStatus.IN_PROGRESS);
            case 2 -> order.setStatus(OrderStatus.FINISHED);
            default -> order.setStatus(OrderStatus.FAILED);
        }
    }
}
