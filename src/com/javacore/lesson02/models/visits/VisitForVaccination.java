package com.javacore.lesson02.models.visits;


import com.javacore.lesson02.base.Visits;
import com.javacore.lesson02.models.client.Client;


public class VisitForVaccination extends Visits {

    private String vaccination;
    private String date;

    public VisitForVaccination(Client client, String vaccination, String date) {
        super(client);
        this.vaccination = vaccination;
        this.date = date;
    }

    public String toString() {
        return "Visite by vaccination: \n client name: "
                + client.getName() + "\n pet type: "
                + client.pet.getType() + "\n pet name: "
                + client.pet.getName()  + "\n pet age: "
                + client.pet.getAge() + "\n vaccination: "
                + vaccination + "\n date next visit: "
                + date;
    }
}
