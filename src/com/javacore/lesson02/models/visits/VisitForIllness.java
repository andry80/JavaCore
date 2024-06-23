package com.javacore.lesson02.models.visits;

import com.javacore.lesson02.base.Visits;
import com.javacore.lesson02.models.client.Client;

public class VisitForIllness extends Visits {

    private String ill;
    private String treatment;
    private String date;

    public VisitForIllness(Client client, String ill, String treatment, String date) {
        super(client);
        this.ill = ill;
        this.treatment = treatment;
        this.date = date;
    }

    public String toString() {
        return "Visite by Ill: \n client name: "
                + client.getName() + "\n pet type: "
                + client.pet.getType() + "\n pet name: "
                + client.pet.getName()  + "\n pet age: "
                + client.pet.getAge() + "\n ill: "
                + ill + "\n treatment: "
                + treatment + "\n date next visit: "
                + date;
    }
}
