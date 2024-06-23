package com.javacore.lesson02.controller;

import com.javacore.lesson02.models.client.Client;
import com.javacore.lesson02.views.View;

import java.io.IOException;

public class Controller {

    private View view;
    private Client client;

    public Controller(View view, Client client) {
        this.view = view;
        this.client = client;
    }

    public void runApp() throws IOException {
        view.registration(client);
        view.choise(client);
    }
}
