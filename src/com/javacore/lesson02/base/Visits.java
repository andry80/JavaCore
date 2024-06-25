package com.javacore.lesson02.base;

import com.javacore.lesson02.models.client.Client;

public abstract class Visits {

    public Client client;

    public Visits(Client client) {
        this.client = client;
    }
}
