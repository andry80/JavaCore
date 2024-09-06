package com.javacore.lesson08;

import java.io.*;
import java.util.ArrayList;

public class OrderSerialization {

    static final String pathToFile = "src/com/javacore/lesson08/OrdersData.bin";

    public static void OrdersSerialization(ArrayList<Order> orders) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
            objectOutputStream.writeInt(orders.size());
            for (Order order: orders) {
                objectOutputStream.writeObject(order);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void OrdersDeserialization(ArrayList<Order> orders) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathToFile))) {
            int fileSize = objectInputStream.readInt();
            for (int i = 0; i < fileSize; i++) {
                orders.add((Order) objectInputStream.readObject());
            }
        } catch (IOException e) {
            System.out.println("No Data");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
