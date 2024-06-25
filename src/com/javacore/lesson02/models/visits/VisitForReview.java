package com.javacore.lesson02.models.visits;

import com.javacore.lesson02.base.Visits;
import com.javacore.lesson02.models.client.Client;

public class VisitForReview extends Visits {

    public VisitForReview(Client client) {
        super(client);
    }

    public String toString() {
        return "Visite by review: \n client name: "
                + client.getName() + "\n pet type: "
                + client.pet.getType() + "\n pet name: "
                + client.pet.getName()  + "\n pet age: "
                + client.pet.getAge();
    }

}
