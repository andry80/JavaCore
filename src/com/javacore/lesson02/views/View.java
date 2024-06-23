package com.javacore.lesson02.views;

import com.javacore.lesson02.base.TypeAnimal;
import com.javacore.lesson02.base.Visits;
import com.javacore.lesson02.models.client.Client;
import com.javacore.lesson02.models.visits.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

    public void choise(Client client) throws IOException {
        System.out.println("1 - visit by ill");
        System.out.println("2 - visit by vaccination");
        System.out.println("3 - visit by review");
        System.out.println("Enter number:");

        switch (Integer.parseInt(reader.readLine())) {
            case 1 -> {
                System.out.println("Enter ill: ");
                String ill = reader.readLine();

                System.out.println("Enter treatment: ");
                String treatment = reader.readLine();

                System.out.println("Enter date next visit day/month/year : ");
                String date = reader.readLine();

                VisitForIllness visite = new VisitForIllness(client,ill, treatment, date);
                check(visite);
            }
            case 2 -> {
                System.out.println("Enter vaccination: ");
                String vaccination = reader.readLine();

                System.out.println("Enter date next visit day/month/year : ");
                String date = reader.readLine();

                VisitForVaccination visite = new VisitForVaccination(client, vaccination, date);
                check(visite);
            }
            default -> {
                VisitForReview visite = new VisitForReview(client);
                check(visite);
            }
        }
    }

    public void registration (Client client) throws IOException {
        System.out.println("enter name: ");
        client.setName(reader.readLine());

        System.out.println("enter surname: ");
        client.setSurname(reader.readLine());

        int i = 0;
        for (TypeAnimal type:TypeAnimal.values()) {
            System.out.println(i++ + " - " + type);
        }
        String  petType = String.valueOf(TypeAnimal.values()[Integer.parseInt(reader.readLine())]);

        System.out.println("enter pet name: ");
        String petName = reader.readLine();

        System.out.println("enter pet age: ");
        int age = Integer.parseInt(reader.readLine());

        client.createPet(petName, age, petType);
    }

    public void check(Visits visit) {
        System.out.println(visit);
    }
}
