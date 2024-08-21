package com.javacore.lesson07;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileReadWriter {

    static final String pathToFile = "src/com/javacore/lesson07/OrdersData.txt";

    public static void readFromFile(ArrayList<Order> orders) throws InvalidStatusException, IOException {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] lst = line.split(";");
                Order order = new Order(Integer.parseInt(lst[0]));
                order.setStatusOrder(OrderStatus.valueOf(lst[1]));
                order.setStartOrderTime(LocalDateTime.parse(lst[2]));
                order.setUpdateOrderTime(LocalDateTime.parse(lst[3]));
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
