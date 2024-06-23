package com.javacore.lesson02;

import com.javacore.lesson02.models.client.Client;
import com.javacore.lesson02.controller.Controller;
import com.javacore.lesson02.views.View;

import java.io.IOException;

public class Clinic {

    public static void main(String[] args) {

        Client client = new Client();
        View view = new View();
        Controller controller = new Controller(view, client);

        try {
            controller.runApp();
        } catch (IOException se) {
            System.out.println(se);
        }

    }

}
