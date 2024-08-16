package com.javacore.lesson07;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileReadWriter {

    static final String pathToFile = "src/com/javacore/lesson07/OrdersData.txt";

    public static void readFromFile(ArrayList<Order> orders) throws IOException, InvalidStatusException {
        int id = 0;
        OrderStatus statusOrder = null;
        LocalDateTime startOrderTime = null;
        LocalDateTime updateOrderTime = null;

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathToFile))) {

            String line;
            StringBuilder stringBuilder;
            int counter = 1;

            while ((line = bufferReader.readLine()) != null) {
                stringBuilder = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ';') {
                        switch (counter) {
                            case 1 -> {
                                id = Integer.parseInt(stringBuilder.toString());
                                counter = 2;
                                stringBuilder = new StringBuilder();
                            }
                            case 2 -> {
                                statusOrder = OrderStatus.valueOf(stringBuilder.toString());
                                counter = 3;
                                stringBuilder = new StringBuilder();
                            }
                            case 3 -> {
                                startOrderTime = LocalDateTime.parse(stringBuilder);
                                counter = 4;
                                stringBuilder = new StringBuilder();
                            }
                        }
                    } else {
                        stringBuilder.append(line.charAt(i));
                    }
                    if (counter == 4 && i == line.length() - 1) {
                        updateOrderTime = LocalDateTime.parse(stringBuilder);
                        counter = 1;
                        stringBuilder = new StringBuilder();
                    }
                }
                Order order = new Order(id);
                order.setStatusOrder(statusOrder);
                order.setStartOrderTime(startOrderTime);
                order.setUpdateOrderTime(updateOrderTime);
                orders.add(order);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("No Data");
        }

    }


    public static void writeToFile(ArrayList<Order> orders) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orders) {
            stringBuilder.append(order.getId())
                    .append(";")
                    .append(order.getStatusOrder())
                    .append(";")
                    .append(order.getStartOrderTime())
                    .append(";")
                    .append(order.getUpdateOrderTime())
                    .append("\n");
        }

        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            for (int i = 0; i < stringBuilder.length(); i++) {
                fileWriter.write(stringBuilder.charAt(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
