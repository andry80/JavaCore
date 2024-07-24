package com.javacore.lesson05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Input {

    TreeSet<Employee> treeSet;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Input(TreeSet treeSet) {
        this.treeSet = treeSet;
    }


    public void menu() throws IOException {
        while (true) {
            System.out.println("1 - enter data");
            System.out.println("2 - view data");
            System.out.println("3 - exit");
            int i = Integer.parseInt(reader.readLine());
            switch (i) {
                case 1 -> enter();
                case 2 -> view();
                default -> {return;}
            }
        }
    }

    public void enter() throws IOException {
        System.out.println("name: ");
        String name = reader.readLine();

        System.out.println("surname: ");
        String surname = reader.readLine();

        System.out.println("type");
        System.out.println("1 - DEV,\n" +
                            "2 - HR,\n" +
                            "3 - MANAGER,\n" +
                            "4 - QA");
        EmpoyeeType type = EmpoyeeType.values()[Integer.parseInt(reader.readLine())-1];

        System.out.println("sallary: ");
        int sallary = Integer.parseInt(reader.readLine());

        treeSet.add(new Employee(name, surname, type, sallary));
    }

    public void view() {
        for (Employee em :treeSet) {
            System.out.print(em.getName() + " ");
            System.out.print(em.getSurname() + " ");
            System.out.print(em.getSalary()+ " ");
            System.out.println(em.getType());
        }
    }

}
